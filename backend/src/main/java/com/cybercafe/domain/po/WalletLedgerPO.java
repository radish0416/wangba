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
 * 钱包流水 实体。
 */
@Data
@TableName("wallet_ledger")
public class WalletLedgerPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 类型 1充值 2消费 3退款 4提现 5冻结 6解冻 */
    private Integer type;

    /** 变动金额 */
    private BigDecimal amount;

    /** 变动后余额 */
    private BigDecimal balanceAfter;

    /** 业务单号 */
    private String bizId;

    /** 备注 */
    private String remark;

}
