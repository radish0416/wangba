/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import lombok.Data;

/**
 * 库存数量 实体。
 */
@Data
@TableName("inventory_stock")
public class InventoryStockPO extends BaseAuditPO {
    /** SKU ID */
    private Long skuId;

    /** 库存数量 */
    private Integer quantity;

}
