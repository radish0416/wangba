/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 订单主表 查询入参。
 */
public class OrderMasterQueryDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 门店/租户ID */
    @Schema(description = "门店/租户ID")
    public Long storeId;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 订单类型 1上机 2商品 3套餐 */
    @Schema(description = "订单类型 1上机 2商品 3套餐")
    public Integer orderType;

    /** 状态 0待支付 1已支付 2已取消 3已退款 4已关闭 */
    @Schema(description = "状态 0待支付 1已支付 2已取消 3已退款 4已关闭")
    public Integer status;

    /** 订单总额 */
    @Schema(description = "订单总额")
    public BigDecimal totalAmount;

    /** 折扣金额 */
    @Schema(description = "折扣金额")
    public BigDecimal discountAmount;

    /** 实付金额 */
    @Schema(description = "实付金额")
    public BigDecimal payAmount;

    /** 支付渠道 0未知 1微信 2支付宝 3钱包 */
    @Schema(description = "支付渠道 0未知 1微信 2支付宝 3钱包")
    public Integer payChannel;

    /** 支付时间 */
    @Schema(description = "支付时间")
    public LocalDateTime payTime;

    /** 外部支付单号 */
    @Schema(description = "外部支付单号")
    public String externalNo;

    /** 机位ID（上机订单） */
    @Schema(description = "机位ID（上机订单）")
    public Long seatId;

    /** 来源渠道 1后台 2小程序 */
    @Schema(description = "来源渠道 1后台 2小程序")
    public Integer sourceChannel;

    /** 备注 */
    @Schema(description = "备注")
    public String remark;

    /** 创建人ID */
    @Schema(description = "创建人ID")
    public Long createBy;

    /** 创建时间 */
    @Schema(description = "创建时间")
    public LocalDateTime createTime;

    /** 修改人ID */
    @Schema(description = "修改人ID")
    public Long updateBy;

    /** 修改时间 */
    @Schema(description = "修改时间")
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    @Schema(description = "扩展字段1")
    public String ext1;

    /** 扩展字段2 */
    @Schema(description = "扩展字段2")
    public String ext2;

    /** 扩展字段3 */
    @Schema(description = "扩展字段3")
    public String ext3;

    /** 扩展字段4 */
    @Schema(description = "扩展字段4")
    public String ext4;

    /** 扩展字段5 */
    @Schema(description = "扩展字段5")
    public String ext5;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
