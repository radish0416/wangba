/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.vo;

/**
 * 订单支付记录 视图对象。
 */
public class OrderPaymentVO {
    /** 主键ID */
    public Long id;

    /** 订单ID */
    public Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    public Integer payChannel;

    /** 商户订单号 */
    public String outTradeNo;

    /** 第三方交易号 */
    public String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    public Integer status;

    /** 支付金额 */
    public BigDecimal amount;

    /** 回调负载JSON */
    public String notifyPayload;

    /** 支付时间 */
    public LocalDateTime payTime;

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
