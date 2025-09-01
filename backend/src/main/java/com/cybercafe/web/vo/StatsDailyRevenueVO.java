/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 每日营收汇总 视图对象。
 */
public class StatsDailyRevenueVO extends BaseAuditVO {
    /** 业务日期 */
    public LocalDate bizDate;

    /** 营收合计 */
    public BigDecimal revenueTotal;

    /** 订单数 */
    public Integer orders;

}
