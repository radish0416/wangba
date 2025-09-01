/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.WalletAccountPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.WalletAccountQueryDTO;

/** 钱包账户 服务。 */
public interface WalletAccountService {
    IPage<WalletAccountPO> listPage(WalletAccountQueryDTO dto);
    java.util.List<WalletAccountPO> listAll(WalletAccountQueryDTO dto);
    WalletAccountPO detail(Long id);
}
