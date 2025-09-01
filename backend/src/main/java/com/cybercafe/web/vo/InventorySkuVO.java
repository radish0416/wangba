/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 库存SKU 视图对象。
 */
public class InventorySkuVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** SKU名称 */
    public String name;

    /** 品类 */
    public String category;

    /** 计量单位 */
    public String unit;

    /** 安全库存 */
    public Integer safetyStock;

    /** 状态 0停用 1启用 */
    public Integer status;

}
