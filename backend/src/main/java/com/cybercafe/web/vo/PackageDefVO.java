/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.vo;

/**
 * 套餐定义 视图对象。
 */
public class PackageDefVO {
    /** 主键ID */
    public Long id;

    /** 门店/租户ID */
    public Long storeId;

    /** 套餐名称 */
    public String name;

    /** 类型 1时间 2次数 3混合 */
    public Integer type;

    /** 售价 */
    public BigDecimal price;

    /** 有效天数 0表示不限 */
    public Integer validDays;

    /** 状态 0下架 1上架 */
    public Integer status;

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
