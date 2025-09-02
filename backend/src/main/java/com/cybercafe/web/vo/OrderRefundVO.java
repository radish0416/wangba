/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 订单退款 视图对象。
 */
public class OrderRefundVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 订单ID */
    public Long orderId;

    /** 退款金额 */
    public BigDecimal amount;

    /** 状态 0申请 1成功 2关闭 */
    public Integer status;

    /** 退款原因 */
    public String reason;

}

