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
    /** 分页查询 */ IPage<InventoryLedgerPO> listPage(InventoryLedgerQueryDTO dto);
    /** 全量查询 */ java.util.List<InventoryLedgerPO> listAll(InventoryLedgerQueryDTO dto);
    /** 详情 */ InventoryLedgerPO detail(Long id);
    /** 新增 */ Boolean create(InventoryLedgerPO po);
    /** 修改 */ Boolean update(InventoryLedgerPO po);
    /** 删除 */ Boolean delete(Long id);
}
