/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.vo;

/**
 * 订单退款 视图对象。
 */
public class OrderRefundVO {
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

    /** 创建人ID */
    public Long createBy;

    /** 创建时间 */
    public LocalDateTime createTime;

    /** 修改人ID */
    public Long updateBy;

    /** 修改时间 */
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    public String ext1;

    /** 扩展字段2 */
    public String ext2;

    /** 扩展字段3 */
    public String ext3;

    /** 扩展字段4 */
    public String ext4;

    /** 扩展字段5 */
    public String ext5;

}
