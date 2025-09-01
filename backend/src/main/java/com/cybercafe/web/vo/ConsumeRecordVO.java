/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
package com.cybercafe.web.vo;

/**
 * 消费记录 视图对象。
 */
public class ConsumeRecordVO {
    /** 主键ID */
    public Long id;

    /** 门店/租户ID */
    public Long storeId;

    /** 用户ID */
    public Long userId;

    /** 订单ID */
    public Long orderId;

    /** 业务类型 1上机 2商品 3套餐 */
    public Integer bizType;

    /** 金额 */
    public BigDecimal amount;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    public Integer payChannel;

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
