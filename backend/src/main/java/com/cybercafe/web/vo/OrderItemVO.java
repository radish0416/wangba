/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigDecimal;
package com.cybercafe.web.vo;

/**
 * 订单明细 视图对象。
 */
public class OrderItemVO {
    /** 主键ID */
    public Long id;

    /** 订单ID */
    public Long orderId;

    /** SKU ID */
    public Long skuId;

    /** 项目标题 */
    public String title;

    /** 数量 */
    public Integer quantity;

    /** 单价 */
    public BigDecimal price;

    /** 金额 */
    public BigDecimal amount;

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
