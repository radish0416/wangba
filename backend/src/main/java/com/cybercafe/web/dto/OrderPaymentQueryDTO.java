/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单支付记录 查询入参。
 */
public class OrderPaymentQueryDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    @Schema(description = "支付渠道 1微信 2支付宝 3钱包")
    public Integer payChannel;

    /** 商户订单号 */
    @Schema(description = "商户订单号")
    public String outTradeNo;

    /** 第三方交易号 */
    @Schema(description = "第三方交易号")
    public String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    @Schema(description = "状态 0创建 1成功 2关闭 3退款")
    public Integer status;

    /** 支付金额 */
    @Schema(description = "支付金额")
    public BigDecimal amount;

    /** 回调负载JSON */
    @Schema(description = "回调负载JSON")
    public String notifyPayload;

    /** 支付时间 */
    @Schema(description = "支付时间")
    public LocalDateTime payTime;

    /** 创建人ID */
    @Schema(description = "创建人ID")
    public Long createBy;

    /** 创建时间 */
    @Schema(description = "创建时间")
    public LocalDateTime createTime;

    /** 修改人ID */
    @Schema(description = "修改人ID")
    public Long updateBy;

    /** 修改时间 */
    @Schema(description = "修改时间")
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    @Schema(description = "扩展字段1")
    public String ext1;

    /** 扩展字段2 */
    @Schema(description = "扩展字段2")
    public String ext2;

    /** 扩展字段3 */
    @Schema(description = "扩展字段3")
    public String ext3;

    /** 扩展字段4 */
    @Schema(description = "扩展字段4")
    public String ext4;

    /** 扩展字段5 */
    @Schema(description = "扩展字段5")
    public String ext5;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
