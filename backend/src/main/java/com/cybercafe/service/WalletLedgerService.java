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
    IPage<WalletLedgerPO> listPage(WalletLedgerQueryDTO dto);
    java.util.List<WalletLedgerPO> listAll(WalletLedgerQueryDTO dto);
    WalletLedgerPO detail(Long id);
}
