/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigDecimal;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 钱包账户 查询入参。
 */
public class WalletAccountQueryDTO extends BaseAuditDTO {
    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 可用余额 */
    @Schema(description = "可用余额")
    public BigDecimal balance;

    /** 冻结金额 */
    @Schema(description = "冻结金额")
    public BigDecimal frozen;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
