/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;

import com.cybercafe.web.BaseAuditDTO;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * 字典类型 查询入参。
 */
public class DictTypeQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 字典编码 */
    @Schema(description = "字典编码")
    public String code;

    /** 字典名称 */
    @Schema(description = "字典名称")
    public String name;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

