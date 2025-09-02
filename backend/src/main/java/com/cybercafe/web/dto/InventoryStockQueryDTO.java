/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 库存数量 查询入参。
 */
public class InventoryStockQueryDTO extends BaseAuditDTO {
    /** SKU ID */
    @Schema(description = "SKU ID")
    public Long skuId;

    /** 库存数量 */
    @Schema(description = "库存数量")
    public Integer quantity;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

