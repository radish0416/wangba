/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 数据范围定义 视图对象。
 */
public class SysDataScopeVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 范围名称 */
    public String name;

    /** 范围规则 1全部 2本门店 3本人 */
    public Integer scopeRule;

}
