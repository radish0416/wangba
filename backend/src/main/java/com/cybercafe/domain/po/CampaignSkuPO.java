/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import lombok.Data;

/**
 * 活动适用SKU 实体。
 */
@Data
@TableName("campaign_sku")
public class CampaignSkuPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 活动ID */
    private Long campaignId;

    /** SKU ID */
    private Long skuId;

}
