/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.WalletAccountService;
import com.cybercafe.repository.mapper.WalletAccountMapper;
import com.cybercafe.domain.po.WalletAccountPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.WalletAccountQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 钱包账户 服务实现。 */
@Service
public class WalletAccountServiceImpl implements WalletAccountService {
    @Autowired
    private WalletAccountMapper mapper;

    @Override
    public IPage<WalletAccountPO> listPage(WalletAccountQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<WalletAccountPO> listAll(WalletAccountQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public WalletAccountPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
