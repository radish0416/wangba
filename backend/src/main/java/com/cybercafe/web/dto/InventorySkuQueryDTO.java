/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 库存SKU 查询入参。
 */
public class InventorySkuQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** SKU名称 */
    @Schema(description = "SKU名称")
    public String name;

    /** 品类 */
    @Schema(description = "品类")
    public String category;

    /** 计量单位 */
    @Schema(description = "计量单位")
    public String unit;

    /** 安全库存 */
    @Schema(description = "安全库存")
    public Integer safetyStock;

    /** 状态 0停用 1启用 */
    @Schema(description = "状态 0停用 1启用")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

