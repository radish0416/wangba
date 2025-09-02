/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 钱包账户 视图对象。
 */
public class WalletAccountVO extends BaseAuditVO {
    /** 用户ID */
    public Long userId;

    /** 可用余额 */
    public BigDecimal balance;

    /** 冻结金额 */
    public BigDecimal frozen;

}

