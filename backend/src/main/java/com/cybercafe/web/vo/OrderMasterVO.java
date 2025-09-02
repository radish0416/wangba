/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 订单主表 视图对象。
 */
public class OrderMasterVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 订单类型 1上机 2商品 3套餐 */
    public Integer orderType;

    /** 状态 0待支付 1已支付 2已取消 3已退款 4已关闭 */
    public Integer status;

    /** 订单总额 */
    public BigDecimal totalAmount;

    /** 折扣金额 */
    public BigDecimal discountAmount;

    /** 实付金额 */
    public BigDecimal payAmount;

    /** 支付渠道 0未知 1微信 2支付宝 3钱包 */
    public Integer payChannel;

    /** 支付时间 */
    public LocalDateTime payTime;

    /** 外部支付单号 */
    public String externalNo;

    /** 机位ID（上机订单） */
    public Long seatId;

    /** 来源渠道 1后台 2小程序 */
    public Integer sourceChannel;

    /** 备注 */
    public String remark;

}

