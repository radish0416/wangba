/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 订单主表 实体。
 */
@Data
@TableName("order_master")
public class OrderMasterPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 门店/租户ID */
    private Long storeId;

    /** 用户ID */
    private Long userId;

    /** 订单类型 1上机 2商品 3套餐 */
    private Integer orderType;

    /** 状态 0待支付 1已支付 2已取消 3已退款 4已关闭 */
    private Integer status;

    /** 订单总额 */
    private BigDecimal totalAmount;

    /** 折扣金额 */
    private BigDecimal discountAmount;

    /** 实付金额 */
    private BigDecimal payAmount;

    /** 支付渠道 0未知 1微信 2支付宝 3钱包 */
    private Integer payChannel;

    /** 支付时间 */
    private LocalDateTime payTime;

    /** 外部支付单号 */
    private String externalNo;

    /** 机位ID（上机订单） */
    private Long seatId;

    /** 来源渠道 1后台 2小程序 */
    private Integer sourceChannel;

    /** 备注 */
    private String remark;

    /** 创建人ID */
    private Long createBy;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改人ID */
    private Long updateBy;

    /** 修改时间 */
    private LocalDateTime updateTime;

    /** 扩展字段1 */
    private String ext1;

    /** 扩展字段2 */
    private String ext2;

    /** 扩展字段3 */
    private String ext3;

    /** 扩展字段4 */
    private String ext4;

    /** 扩展字段5 */
    private String ext5;

}
