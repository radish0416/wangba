/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 库存流水 查询入参。
 */
public class InventoryLedgerQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** SKU ID */
    @Schema(description = "SKU ID")
    public Long skuId;

    /** 类型 1入库 2出库 3调整 */
    @Schema(description = "类型 1入库 2出库 3调整")
    public Integer type;

    /** 数量(入正出负) */
    @Schema(description = "数量(入正出负)")
    public Integer quantity;

    /** 备注 */
    @Schema(description = "备注")
    public String remark;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

