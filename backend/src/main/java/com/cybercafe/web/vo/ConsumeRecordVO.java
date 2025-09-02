/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 消费记录 视图对象。
 */
public class ConsumeRecordVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 订单ID */
    public Long orderId;

    /** 业务类型 1上机 2商品 3套餐 */
    public Integer bizType;

    /** 金额 */
    public BigDecimal amount;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    public Integer payChannel;

}

