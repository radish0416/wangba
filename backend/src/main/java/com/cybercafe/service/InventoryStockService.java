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
    IPage<InventoryStockPO> listPage(InventoryStockQueryDTO dto);
    java.util.List<InventoryStockPO> listAll(InventoryStockQueryDTO dto);
    InventoryStockPO detail(Long id);
}
