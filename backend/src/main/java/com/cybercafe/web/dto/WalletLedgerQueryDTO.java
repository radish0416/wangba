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
 * 钱包流水 查询入参。
 */
public class WalletLedgerQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 类型 1充值 2消费 3退款 4提现 5冻结 6解冻 */
    @Schema(description = "类型 1充值 2消费 3退款 4提现 5冻结 6解冻")
    public Integer type;

    /** 变动金额 */
    @Schema(description = "变动金额")
    public BigDecimal amount;

    /** 变动后余额 */
    @Schema(description = "变动后余额")
    public BigDecimal balanceAfter;

    /** 业务单号 */
    @Schema(description = "业务单号")
    public String bizId;

    /** 备注 */
    @Schema(description = "备注")
    public String remark;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
