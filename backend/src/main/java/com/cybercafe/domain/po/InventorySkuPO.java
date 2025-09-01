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
 * 库存SKU 实体。
 */
@Data
@TableName("inventory_sku")
public class InventorySkuPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** SKU名称 */
    private String name;

    /** 品类 */
    private String category;

    /** 计量单位 */
    private String unit;

    /** 安全库存 */
    private Integer safetyStock;

    /** 状态 0停用 1启用 */
    private Integer status;

}
