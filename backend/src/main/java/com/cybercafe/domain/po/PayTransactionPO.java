/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 支付交易 实体。
 */
@Data
@TableName("pay_transaction")
public class PayTransactionPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    private Integer channel;

    /** 第三方交易号 */
    private String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    private Integer status;

    /** 金额 */
    private BigDecimal amount;

}
