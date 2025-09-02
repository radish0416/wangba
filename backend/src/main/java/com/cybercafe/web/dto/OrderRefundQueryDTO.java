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
 * 订单退款 查询入参。
 */
public class OrderRefundQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** 退款金额 */
    @Schema(description = "退款金额")
    public BigDecimal amount;

    /** 状态 0申请 1成功 2关闭 */
    @Schema(description = "状态 0申请 1成功 2关闭")
    public Integer status;

    /** 退款原因 */
    @Schema(description = "退款原因")
    public String reason;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

