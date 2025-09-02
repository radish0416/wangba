/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 商品SKU 查询入参。
 */
public class GoodsSkuQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 商品ID */
    @Schema(description = "商品ID")
    public Long goodsId;

    /** SKU编码 */
    @Schema(description = "SKU编码")
    public String skuCode;

    /** 售价 */
    @Schema(description = "售价")
    public BigDecimal price;

    /** 状态 0停用 1启用 */
    @Schema(description = "状态 0停用 1启用")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

