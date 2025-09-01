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
 * 订单退款 实体。
 */
@Data
@TableName("order_refund")
public class OrderRefundPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 订单ID */
    private Long orderId;

    /** 退款金额 */
    private BigDecimal amount;

    /** 状态 0申请 1成功 2关闭 */
    private Integer status;

    /** 退款原因 */
    private String reason;

}
