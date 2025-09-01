/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.InventorySkuService;
import com.cybercafe.repository.mapper.InventorySkuMapper;
import com.cybercafe.domain.po.InventorySkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventorySkuQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 库存SKU 服务实现。 */
@Service
public class InventorySkuServiceImpl implements InventorySkuService {
    @Autowired
    private InventorySkuMapper mapper;

    @Override
    public IPage<InventorySkuPO> listPage(InventorySkuQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<InventorySkuPO> listAll(InventorySkuQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public InventorySkuPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
