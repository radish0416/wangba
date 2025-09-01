/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 活动适用SKU 查询入参。
 */
public class CampaignSkuQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 活动ID */
    @Schema(description = "活动ID")
    public Long campaignId;

    /** SKU ID */
    @Schema(description = "SKU ID")
    public Long skuId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
