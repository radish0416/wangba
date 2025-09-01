/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.InventoryStockPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventoryStockQueryDTO;

/** 库存数量 服务。 */
public interface InventoryStockService {
    /** 分页查询 */ IPage<InventoryStockPO> listPage(InventoryStockQueryDTO dto);
    /** 全量查询 */ java.util.List<InventoryStockPO> listAll(InventoryStockQueryDTO dto);
    /** 详情 */ InventoryStockPO detail(Long id);
    /** 新增 */ Boolean create(InventoryStockPO po);
    /** 修改 */ Boolean update(InventoryStockPO po);
    /** 删除 */ Boolean delete(Long id);
}
