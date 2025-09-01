/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;

/**
 * 库存流水 视图对象。
 */
public class InventoryLedgerVO {
    /** 主键ID */
    public Long id;

    /** SKU ID */
    public Long skuId;

    /** 门店/租户ID */
    public Long storeId;

    /** 类型 1入库 2出库 3调整 */
    public Integer type;

    /** 数量(入正出负) */
    public Integer quantity;

    /** 备注 */
    public String remark;

    /** 创建人ID */
    public Long createBy;

    /** 创建时间 */
    public LocalDateTime createTime;

    /** 修改人ID */
    public Long updateBy;

    /** 修改时间 */
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    public String ext1;

    /** 扩展字段2 */
    public String ext2;

    /** 扩展字段3 */
    public String ext3;

    /** 扩展字段4 */
    public String ext4;

    /** 扩展字段5 */
    public String ext5;

}
