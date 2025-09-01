/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 库存流水 视图对象。
 */
public class InventoryLedgerVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** SKU ID */
    public Long skuId;

    /** 类型 1入库 2出库 3调整 */
    public Integer type;

    /** 数量(入正出负) */
    public Integer quantity;

    /** 备注 */
    public String remark;

}
