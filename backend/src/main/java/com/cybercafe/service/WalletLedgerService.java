/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.WalletLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.WalletLedgerQueryDTO;

/** 钱包流水 服务。 */
public interface WalletLedgerService {
    /** 分页查询 */ IPage<WalletLedgerPO> listPage(WalletLedgerQueryDTO dto);
    /** 全量查询 */ java.util.List<WalletLedgerPO> listAll(WalletLedgerQueryDTO dto);
    /** 详情 */ WalletLedgerPO detail(Long id);
    /** 新增 */ Boolean create(WalletLedgerPO po);
    /** 修改 */ Boolean update(WalletLedgerPO po);
    /** 删除 */ Boolean delete(Long id);
}
