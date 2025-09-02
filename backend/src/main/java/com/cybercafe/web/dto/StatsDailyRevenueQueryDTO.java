/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 每日营收汇总 查询入参。
 */
public class StatsDailyRevenueQueryDTO extends BaseAuditDTO {
    /** 业务日期 */
    @Schema(description = "业务日期")
    public LocalDate bizDate;

    /** 营收合计 */
    @Schema(description = "营收合计")
    public BigDecimal revenueTotal;

    /** 订单数 */
    @Schema(description = "订单数")
    public Integer orders;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

