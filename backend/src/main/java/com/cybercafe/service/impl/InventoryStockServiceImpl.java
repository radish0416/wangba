/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.InventoryStockService;
import com.cybercafe.repository.mapper.InventoryStockMapper;
import com.cybercafe.domain.po.InventoryStockPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.InventoryStockQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 库存数量 服务实现。 */
@Service
public class InventoryStockServiceImpl implements InventoryStockService {
    private static final Logger log = LoggerFactory.getLogger(InventoryStockServiceImpl.class);
    @Resource
    private InventoryStockMapper mapper;

    @Override
    public IPage<InventoryStockPO> listPage(InventoryStockQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<InventoryStockPO> listAll(InventoryStockQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public InventoryStockPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(InventoryStockPO po) {
        log.info("create inventory_stock id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(InventoryStockPO po) {
        log.info("update inventory_stock id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete inventory_stock id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
