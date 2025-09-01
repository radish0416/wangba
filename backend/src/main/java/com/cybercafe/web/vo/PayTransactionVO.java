/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 支付交易 视图对象。
 */
public class PayTransactionVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 订单ID */
    public Long orderId;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    public Integer channel;

    /** 第三方交易号 */
    public String tradeNo;

    /** 状态 0创建 1成功 2关闭 3退款 */
    public Integer status;

    /** 金额 */
    public BigDecimal amount;

}
