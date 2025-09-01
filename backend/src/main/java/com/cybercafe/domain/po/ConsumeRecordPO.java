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
 * 消费记录 实体。
 */
@Data
@TableName("consume_record")
public class ConsumeRecordPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 订单ID */
    private Long orderId;

    /** 业务类型 1上机 2商品 3套餐 */
    private Integer bizType;

    /** 金额 */
    private BigDecimal amount;

    /** 支付渠道 1微信 2支付宝 3钱包 */
    private Integer payChannel;

}
