/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;

/**
 * 数据范围定义 视图对象。
 */
public class SysDataScopeVO {
    /** 主键ID */
    public Long id;

    /** 范围名称 */
    public String name;

    /** 范围规则 1全部 2本门店 3本人 */
    public Integer scopeRule;

    /** 创建人ID */
    public Long createBy;

    /** 创建时间 */
    public LocalDateTime createTime;

    /** 修改人ID */
    public Long updateBy;

    /** 修改时间 */
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    public String ext1;

    /** 扩展字段2 */
    public String ext2;

    /** 扩展字段3 */
    public String ext3;

    /** 扩展字段4 */
    public String ext4;

    /** 扩展字段5 */
    public String ext5;

}
