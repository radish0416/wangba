/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.InventorySkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventorySkuQueryDTO;

/** 库存SKU 服务。 */
public interface InventorySkuService {
    IPage<InventorySkuPO> listPage(InventorySkuQueryDTO dto);
    java.util.List<InventorySkuPO> listAll(InventorySkuQueryDTO dto);
    InventorySkuPO detail(Long id);
}
