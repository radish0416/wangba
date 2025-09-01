/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.InventoryLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventoryLedgerQueryDTO;

/** 库存流水 服务。 */
public interface InventoryLedgerService {
    IPage<InventoryLedgerPO> listPage(InventoryLedgerQueryDTO dto);
    java.util.List<InventoryLedgerPO> listAll(InventoryLedgerQueryDTO dto);
    InventoryLedgerPO detail(Long id);
}
