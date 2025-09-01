/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.WalletLedgerService;
import com.cybercafe.repository.mapper.WalletLedgerMapper;
import com.cybercafe.domain.po.WalletLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.WalletLedgerQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 钱包流水 服务实现。 */
@Service
public class WalletLedgerServiceImpl implements WalletLedgerService {
    private static final Logger log = LoggerFactory.getLogger(WalletLedgerServiceImpl.class);
    @Resource
    private WalletLedgerMapper mapper;

    @Override
    public IPage<WalletLedgerPO> listPage(WalletLedgerQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<WalletLedgerPO> listAll(WalletLedgerQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public WalletLedgerPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(WalletLedgerPO po) {
        log.info("create wallet_ledger id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(WalletLedgerPO po) {
        log.info("update wallet_ledger id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete wallet_ledger id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
