/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 消费记录 查询入参。
 */
public class ConsumeRecordQueryDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 门店/租户ID */
    @Schema(description = "门店/租户ID")
    public Long storeId;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** 业务类型 1上机 2商品 3套餐 */
    @Schema(description = "业务类型 1上机 2商品 3套餐")
    public Integer bizType;

    /** 金额 */
    @Schema(description = "金额")
    public BigDecimal amount;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    @Schema(description = "支付渠道 1微信 2支付宝 3钱包")
    public Integer payChannel;

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
