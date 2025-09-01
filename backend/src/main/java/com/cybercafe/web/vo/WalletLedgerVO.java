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
 * 钱包流水 视图对象。
 */
public class WalletLedgerVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 类型 1充值 2消费 3退款 4提现 5冻结 6解冻 */
    public Integer type;

    /** 变动金额 */
    public BigDecimal amount;

    /** 变动后余额 */
    public BigDecimal balanceAfter;

    /** 业务单号 */
    public String bizId;

    /** 备注 */
    public String remark;

}
