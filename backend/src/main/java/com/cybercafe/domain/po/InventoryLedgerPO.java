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
 * 库存流水 实体。
 */
@Data
@TableName("inventory_ledger")
public class InventoryLedgerPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** SKU ID */
    private Long skuId;

    /** 类型 1入库 2出库 3调整 */
    private Integer type;

    /** 数量(入正出负) */
    private Integer quantity;

    /** 备注 */
    private String remark;

}
