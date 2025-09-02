/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 订单明细 查询入参。
 */
public class OrderItemQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** SKU ID */
    @Schema(description = "SKU ID")
    public Long skuId;

    /** 项目标题 */
    @Schema(description = "项目标题")
    public String title;

    /** 数量 */
    @Schema(description = "数量")
    public Integer quantity;

    /** 单价 */
    @Schema(description = "单价")
    public BigDecimal price;

    /** 金额 */
    @Schema(description = "金额")
    public BigDecimal amount;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

