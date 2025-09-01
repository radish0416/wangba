#!/usr/bin/env python3
import os
import re
from pathlib import Path
from typing import List, Tuple

ROOT = Path('/workspace')
SQL_DIR = ROOT / 'docs-v3' / 'modules'
OUT_JAVA = ROOT / 'backend' / 'src' / 'main' / 'java' / 'com' / 'cybercafe'
OUT_RES = ROOT / 'backend' / 'src' / 'main' / 'resources' / 'mapper'

JAVA_PACKAGE_BASE = 'com.cybercafe'

SQL_TABLE_RE = re.compile(r"CREATE TABLE\s+`(?P<name>[^`]+)`\s*\((?P<body>[\s\S]*?)\)\s*ENGINE=", re.MULTILINE)
SQL_COLUMN_RE = re.compile(r"\s*`(?P<col>[^`]+)`\s+(?P<type>[^\s]+)[^,]*COMMENT\s+'(?P<comment>[^']*)'\s*,?", re.IGNORECASE)
SQL_TBL_COMMENT_RE = re.compile(r"\)\s*ENGINE=[^\s]+\s+DEFAULT\s+CHARSET=[^\s]+\s+COMMENT='(?P<comment>[^']*)'", re.IGNORECASE)

JAVA_TYPE_MAP = {
    'bigint': 'Long',
    'int': 'Integer',
    'tinyint': 'Integer',
    'varchar': 'String',
    'mediumtext': 'String',
    'json': 'String',
    'datetime': 'java.time.LocalDateTime',
    'date': 'java.time.LocalDate',
    'decimal': 'java.math.BigDecimal'
}

COMMON_AUDIT_FIELDS = { 'storeId','createBy','createTime','updateBy','updateTime','ext1','ext2','ext3','ext4','ext5' }

HEADER = """/**
 * 本文件由工具自动生成，请勿手工修改。\n * 生成器: tools/codegen/generate_from_sql.py
 */
"""


def sql_type_to_java(sql_type: str) -> Tuple[str, List[str]]:
    base = sql_type.split('(')[0].lower()
    j = JAVA_TYPE_MAP.get(base, 'String')
    imports: List[str] = []
    if '.' in j:
        imports.append(j)
        j_simple = j.split('.')[-1]
        return j_simple, imports
    return j, imports


def to_camel(s: str) -> str:
    return s


def upper_camel(s: str) -> str:
    parts = re.split(r'[_-]', s)
    if len(parts) == 1:
        return s[:1].upper() + s[1:]
    return ''.join(p.capitalize() for p in parts)


def parse_tables(sql_text: str):
    tables = []
    for m in SQL_TABLE_RE.finditer(sql_text):
        name = m.group('name')
        body = m.group('body')
        columns = []
        for c in SQL_COLUMN_RE.finditer(body):
            col = c.group('col')
            typ = c.group('type')
            comment = c.group('comment')
            columns.append((col, typ, comment))
        tail = sql_text[m.start():sql_text.find(';', m.end())]
        tm = SQL_TBL_COMMENT_RE.search(tail)
        tcomment = tm.group('comment') if tm else name
        tables.append((name, tcomment, columns))
    return tables


def ensure_dirs():
    for p in [OUT_JAVA / 'domain' / 'po', OUT_JAVA / 'web' / 'dto', OUT_JAVA / 'web' / 'vo', OUT_JAVA / 'repository' / 'mapper', OUT_JAVA / 'service', OUT_JAVA / 'service' / 'impl', OUT_JAVA / 'web' / 'controller']:
        p.mkdir(parents=True, exist_ok=True)
    OUT_RES.mkdir(parents=True, exist_ok=True)


def gen_po(table, comment, columns):
    class_name = upper_camel(table) + 'PO'
    imports = set(['com.baomidou.mybatisplus.annotation.TableName', 'lombok.Data', f'{JAVA_PACKAGE_BASE}.domain.BaseAuditPO'])
    has_id = any(col == 'id' for col, _, _ in columns)
    if has_id:
        imports.add('com.baomidou.mybatisplus.annotation.TableId')
    for col, t, _ in columns:
        if col in COMMON_AUDIT_FIELDS:
            continue
        j, imps = sql_type_to_java(t)
        for imp in imps:
            imports.add(imp)
    lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.domain.po;\n",]
    for imp in sorted(imports):
        lines.append(f"import {imp};\n")
    lines.append("\n/**\n * %s 实体。\n */\n" % comment)
    lines.append("@Data\n@TableName(\"%s\")\n" % table)
    lines.append(f"public class {class_name} extends BaseAuditPO {{\n")
    for col, t, c in columns:
        if col in COMMON_AUDIT_FIELDS:
            continue
        j, _ = sql_type_to_java(t)
        if col == 'id' and has_id:
            lines.append("    @TableId\n")
        lines.append(f"    /** {c} */\n")
        lines.append(f"    private {j} {to_camel(col)};\n\n")
    lines.append("}\n")
    (OUT_JAVA / 'domain' / 'po' / f"{class_name}.java").write_text(''.join(lines))
    return class_name


def gen_dto_vo(table, comment, columns):
    base_name = upper_camel(table)
    # QueryDTO
    dto_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.web.dto;\n", 'import io.swagger.v3.oas.annotations.media.Schema;\n', f"import {JAVA_PACKAGE_BASE}.web.BaseAuditDTO;\n"]
    for _, t, _ in columns:
        j, imps = sql_type_to_java(t)
        if imps:
            dto_lines.insert(1, f"import {imps[0]};\n")
    dto_lines.append("\n/**\n * %s 查询入参。\n */\n" % comment)
    dto_lines.append(f"public class {base_name}QueryDTO extends BaseAuditDTO {{\n")
    for col, t, c in columns:
        if col in COMMON_AUDIT_FIELDS:
            continue
        j, _ = sql_type_to_java(t)
        dto_lines.append(f"    /** {c} */\n")
        dto_lines.append(f"    @Schema(description = \"{c}\")\n")
        dto_lines.append(f"    public {j} {to_camel(col)};\n\n")
    dto_lines.append("    /** 当前页 */\n    public Long current;\n\n")
    dto_lines.append("    /** 每页大小 */\n    public Long size;\n")
    dto_lines.append("}\n")
    (OUT_JAVA / 'web' / 'dto' / f"{base_name}QueryDTO.java").write_text(''.join(dto_lines))

    # VO
    vo_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.web.vo;\n", f"import {JAVA_PACKAGE_BASE}.web.BaseAuditVO;\n"]
    for _, t, _ in columns:
        j, imps = sql_type_to_java(t)
        if imps:
            vo_lines.insert(1, f"import {imps[0]};\n")
    vo_lines.append("\n/**\n * %s 视图对象。\n */\n" % comment)
    vo_lines.append(f"public class {base_name}VO extends BaseAuditVO {{\n")
    for col, t, c in columns:
        if col in COMMON_AUDIT_FIELDS:
            continue
        j, _ = sql_type_to_java(t)
        vo_lines.append(f"    /** {c} */\n")
        vo_lines.append(f"    public {j} {to_camel(col)};\n\n")
    vo_lines.append("}\n")
    (OUT_JAVA / 'web' / 'vo' / f"{base_name}VO.java").write_text(''.join(vo_lines))


def gen_mapper_and_xml(table, comment, columns, po_class):
    base_name = upper_camel(table)
    mapper_name = base_name + 'Mapper'
    # Java mapper
    mapper_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.repository.mapper;\n",
                    'import com.baomidou.mybatisplus.core.mapper.BaseMapper;\n',
                    f"import {JAVA_PACKAGE_BASE}.domain.po.{po_class};\n",
                    'import com.baomidou.mybatisplus.core.metadata.IPage;\n',
                    'import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n',
                    'import org.apache.ibatis.annotations.Param;\n',
                    f"import {JAVA_PACKAGE_BASE}.web.dto.{base_name}QueryDTO;\n\n",
                    f"/** {comment} Mapper。 */\n",
                    f"public interface {mapper_name} extends BaseMapper<{po_class}> {{\n",
                    f"    IPage<{po_class}> selectByDynamic(Page<?> page, @Param(\"dto\") {base_name}QueryDTO dto);\n",
                    f"    {po_class} selectDetail(@Param(\"id\") Long id);\n",
                    "}\n"]
    (OUT_JAVA / 'repository' / 'mapper' / f"{mapper_name}.java").write_text(''.join(mapper_lines))

    # XML
    resultMap = [f"<resultMap id=\"BaseResultMap\" type=\"{JAVA_PACKAGE_BASE}.domain.po.{po_class}\">\n"]
    for col, t, c in columns:
        tag = 'id' if col == 'id' else 'result'
        resultMap.append(f"  <{tag} column=\"{col}\" property=\"{to_camel(col)}\"/>\n")
    resultMap.append("</resultMap>\n")

    select_all = "SELECT " + ", ".join([f"`{c[0]}`" for c in columns]) + f" FROM `{table}`"

    where_lines = ["  <where>\n"]
    for col, t, c in columns:
        where_lines.append(f"    <if test=\"dto.{to_camel(col)} != null and dto.{to_camel(col)} != ''\">\n      AND `{col}` = #{{dto.{to_camel(col)}}}\n    </if>\n")
    where_lines.append("  </where>\n")

    xml_lines = ["<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n",
                 "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n",
                 f"<mapper namespace=\"{JAVA_PACKAGE_BASE}.repository.mapper.{mapper_name}\">\n\n",
                 "  <!-- 结果映射 -->\n", *resultMap, "\n",
                 "  <!-- 动态查询（分页与全量共用） -->\n",
                 f"  <select id=\"selectByDynamic\" resultMap=\"BaseResultMap\">\n    {select_all}\n".format(select_all=select_all),
                 *where_lines,
                 "    ORDER BY id DESC\n  </select>\n\n",
                 "  <!-- 详情查询 -->\n",
                 f"  <select id=\"selectDetail\" resultMap=\"BaseResultMap\">\n    {select_all} WHERE id = #{{id}}\n  </select>\n",
                 "</mapper>\n"]
    (OUT_RES / f"{table}.xml").write_text(''.join(xml_lines))


def gen_service_controller(table, comment, po_class):
    base_name = upper_camel(table)
    service_name = base_name + 'Service'
    impl_name = base_name + 'ServiceImpl'

    # Service interface
    svc_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.service;\n", f"import {JAVA_PACKAGE_BASE}.domain.po.{po_class};\n",
                 'import com.baomidou.mybatisplus.core.metadata.IPage;\n',
                 'import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n',
                 f"import {JAVA_PACKAGE_BASE}.web.dto.{base_name}QueryDTO;\n\n",
                 f"/** {comment} 服务。 */\n",
                 f"public interface {service_name} {{\n",
                 f"    /** 分页查询 */ IPage<{po_class}> listPage({base_name}QueryDTO dto);\n",
                 f"    /** 全量查询 */ java.util.List<{po_class}> listAll({base_name}QueryDTO dto);\n",
                 f"    /** 详情 */ {po_class} detail(Long id);\n",
                 f"    /** 新增 */ Boolean create({po_class} po);\n",
                 f"    /** 修改 */ Boolean update({po_class} po);\n",
                 f"    /** 删除 */ Boolean delete(Long id);\n",
                 "}\n"]
    (OUT_JAVA / 'service' / f"{service_name}.java").write_text(''.join(svc_lines))

    # Service impl
    impl_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.service.impl;\n",
                  f"import {JAVA_PACKAGE_BASE}.service.{service_name};\n",
                  f"import {JAVA_PACKAGE_BASE}.repository.mapper.{upper_camel(table)}Mapper;\n",
                  f"import {JAVA_PACKAGE_BASE}.domain.po.{po_class};\n",
                  'import com.baomidou.mybatisplus.core.metadata.IPage;\n',
                  'import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n',
                  f"import {JAVA_PACKAGE_BASE}.web.dto.{base_name}QueryDTO;\n",
                  'import org.springframework.stereotype.Service;\n',
                  'import jakarta.annotation.Resource;\n',
                  'import org.slf4j.Logger;\n',
                  'import org.slf4j.LoggerFactory;\n\n',
                  f"/** {comment} 服务实现。 */\n",
                  '@Service\n',
                  f"public class {impl_name} implements {service_name} {{\n",
                  f"    private static final Logger log = LoggerFactory.getLogger({impl_name}.class);\n",
                  f"    @Resource\n    private {upper_camel(table)}Mapper mapper;\n\n",
                  f"    @Override\n    public IPage<{po_class}> listPage({base_name}QueryDTO dto) {{\n        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);\n        return mapper.selectByDynamic(page, dto);\n    }}\n\n",
                  f"    @Override\n    public java.util.List<{po_class}> listAll({base_name}QueryDTO dto) {{\n        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();\n    }}\n\n",
                  f"    @Override\n    public {po_class} detail(Long id) {{\n        return mapper.selectDetail(id);\n    }}\n\n",
                  f"    @Override\n    public Boolean create({po_class} po) {{\n        log.info(\"create {table} id={{}}\", po.getId());\n        return mapper.insert(po) > 0;\n    }}\n\n",
                  f"    @Override\n    public Boolean update({po_class} po) {{\n        log.info(\"update {table} id={{}}\", po.getId());\n        return mapper.updateById(po) > 0;\n    }}\n\n",
                  f"    @Override\n    public Boolean delete(Long id) {{\n        log.warn(\"delete {table} id={{}}\", id);\n        return mapper.deleteById(id) > 0;\n    }}\n",
                  "}\n"]
    (OUT_JAVA / 'service' / 'impl' / f"{impl_name}.java").write_text(''.join(impl_lines))

    # Controller
    ctl_lines = [HEADER, f"package {JAVA_PACKAGE_BASE}.web.controller;\n",
                 f"import {JAVA_PACKAGE_BASE}.service.{service_name};\n",
                 f"import {JAVA_PACKAGE_BASE}.domain.po.{po_class};\n",
                 f"import {JAVA_PACKAGE_BASE}.web.dto.{base_name}QueryDTO;\n",
                 f"import {JAVA_PACKAGE_BASE}.common.ApiResponse;\n",
                 'import com.baomidou.mybatisplus.core.metadata.IPage;\n',
                 'import io.swagger.v3.oas.annotations.tags.Tag;\n',
                 'import io.swagger.v3.oas.annotations.Operation;\n',
                 'import org.springframework.validation.annotation.Validated;\n',
                 'import org.springframework.web.bind.annotation.*;\n',
                 'import jakarta.annotation.Resource;\n\n',
                 f"/** {comment} 控制器。 */\n",
                 '@RestController\n', f"@RequestMapping(\"/api/{table}\")\n",
                 '@Tag(name = "' + comment + '")\n',
                 f"public class {base_name}Controller {{\n",
                 f"    @Resource\n    private {service_name} service;\n\n",
                 '@PostMapping("/listPage")\n@Operation(summary = "分页查询")\n',
                 f"    public ApiResponse<IPage<{po_class}>> listPage(@RequestBody @Validated {base_name}QueryDTO dto) {{\n        return ApiResponse.ok(service.listPage(dto));\n    }}\n\n",
                 '@PostMapping("/listAll")\n@Operation(summary = "全量查询")\n',
                 f"    public ApiResponse<java.util.List<{po_class}>> listAll(@RequestBody @Validated {base_name}QueryDTO dto) {{\n        return ApiResponse.ok(service.listAll(dto));\n    }}\n\n",
                 '@PostMapping("/detail")\n@Operation(summary = "详情")\n',
                 f"    public ApiResponse<{po_class}> detail(@RequestBody java.util.Map<String, Long> req) {{\n        return ApiResponse.ok(service.detail(req.get(\"id\")));\n    }}\n\n",
                 '@PostMapping("/create")\n@Operation(summary = "新增")\n',
                 f"    public ApiResponse<Boolean> create(@RequestBody @Validated {po_class} po) {{\n        return ApiResponse.ok(service.create(po));\n    }}\n\n",
                 '@PostMapping("/update")\n@Operation(summary = "修改")\n',
                 f"    public ApiResponse<Boolean> update(@RequestBody @Validated {po_class} po) {{\n        return ApiResponse.ok(service.update(po));\n    }}\n\n",
                 '@PostMapping("/delete")\n@Operation(summary = "删除")\n',
                 f"    public ApiResponse<Boolean> delete(@RequestBody java.util.Map<String, Long> req) {{\n        return ApiResponse.ok(service.delete(req.get(\"id\")));\n    }}\n",
                 "}\n"]
    (OUT_JAVA / 'web' / 'controller' / f"{base_name}Controller.java").write_text(''.join(ctl_lines))


def main():
    ensure_dirs()
    for sql_path in sorted(SQL_DIR.glob('**/db.sql')):
        sql_text = sql_path.read_text()
        tables = parse_tables(sql_text)
        for table, tcomment, cols in tables:
            po = gen_po(table, tcomment, cols)
            gen_dto_vo(table, tcomment, cols)
            gen_mapper_and_xml(table, tcomment, cols, po)
            gen_service_controller(table, tcomment, po)
    print('Code generation completed.')

if __name__ == '__main__':
    main()