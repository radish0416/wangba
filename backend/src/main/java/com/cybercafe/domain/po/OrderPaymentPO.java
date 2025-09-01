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
 * 订单支付记录 实体。
 */
@Data
@TableName("order_payment")
public class OrderPaymentPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    private Integer payChannel;

    /** 商户订单号 */
    private String outTradeNo;

    /** 第三方交易号 */
    private String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    private Integer status;

    /** 支付金额 */
    private BigDecimal amount;

    /** 回调负载JSON */
    private String notifyPayload;

    /** 支付时间 */
    private LocalDateTime payTime;

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
