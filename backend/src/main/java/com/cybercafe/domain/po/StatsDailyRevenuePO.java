/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

/**
 * 每日营收汇总 实体。
 */
@Data
@TableName("stats_daily_revenue")
public class StatsDailyRevenuePO extends BaseAuditPO {
    /** 业务日期 */
    private LocalDate bizDate;

    /** 营收合计 */
    private BigDecimal revenueTotal;

    /** 订单数 */
    private Integer orders;

}
