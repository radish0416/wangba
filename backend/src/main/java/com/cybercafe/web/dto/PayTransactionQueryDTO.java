/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 支付交易 查询入参。
 */
public class PayTransactionQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    @Schema(description = "支付渠道 1微信 2支付宝 3钱包")
    public Integer channel;

    /** 第三方交易号 */
    @Schema(description = "第三方交易号")
    public String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    @Schema(description = "状态 0创建 1成功 2关闭 3退款")
    public Integer status;

    /** 金额 */
    @Schema(description = "金额")
    public BigDecimal amount;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
