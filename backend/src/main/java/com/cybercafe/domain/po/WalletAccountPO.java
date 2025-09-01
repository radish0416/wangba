/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 钱包账户 实体。
 */
@Data
@TableName("wallet_account")
public class WalletAccountPO extends BaseAuditPO {
    /** 用户ID */
    private Long userId;

    /** 可用余额 */
    private BigDecimal balance;

    /** 冻结金额 */
    private BigDecimal frozen;

}
