/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.OrderItemService;
import com.cybercafe.repository.mapper.OrderItemMapper;
import com.cybercafe.domain.po.OrderItemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderItemQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 订单明细 服务实现。 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private static final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);
    @Resource
    private OrderItemMapper mapper;

    @Override
    public IPage<OrderItemPO> listPage(OrderItemQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<OrderItemPO> listAll(OrderItemQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public OrderItemPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(OrderItemPO po) {
        log.info("create order_item id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(OrderItemPO po) {
        log.info("update order_item id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete order_item id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
