/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 订单明细 实体。
 */
@Data
@TableName("order_item")
public class OrderItemPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** SKU ID */
    private Long skuId;

    /** 项目标题 */
    private String title;

    /** 数量 */
    private Integer quantity;

    /** 单价 */
    private BigDecimal price;

    /** 金额 */
    private BigDecimal amount;

    /** 创建人ID */
    private Long createBy;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改人ID */
    private Long updateBy;

    /** 修改时间 */
    private LocalDateTime updateTime;

    /** 扩展字段1 */
    private String ext1;

    /** 扩展字段2 */
    private String ext2;

    /** 扩展字段3 */
    private String ext3;

    /** 扩展字段4 */
    private String ext4;

    /** 扩展字段5 */
    private String ext5;

}
