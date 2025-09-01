/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.InventoryLedgerService;
import com.cybercafe.repository.mapper.InventoryLedgerMapper;
import com.cybercafe.domain.po.InventoryLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventoryLedgerQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 库存流水 服务实现。 */
@Service
public class InventoryLedgerServiceImpl implements InventoryLedgerService {
    @Autowired
    private InventoryLedgerMapper mapper;

    @Override
    public IPage<InventoryLedgerPO> listPage(InventoryLedgerQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<InventoryLedgerPO> listAll(InventoryLedgerQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public InventoryLedgerPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
