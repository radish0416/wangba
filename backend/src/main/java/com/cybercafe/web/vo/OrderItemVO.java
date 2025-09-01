/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigDecimal;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 订单明细 视图对象。
 */
public class OrderItemVO extends BaseAuditVO {
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

}
