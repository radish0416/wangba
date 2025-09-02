/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.OrderRefundService;
import com.cybercafe.repository.mapper.OrderRefundMapper;
import com.cybercafe.domain.po.OrderRefundPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderRefundQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 订单退款 服务实现。 */
@Service
public class OrderRefundServiceImpl implements OrderRefundService {
    private static final Logger log = LoggerFactory.getLogger(OrderRefundServiceImpl.class);
    @Resource
    private OrderRefundMapper mapper;

    @Override
    public IPage<OrderRefundPO> listPage(OrderRefundQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<OrderRefundPO> listAll(OrderRefundQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public OrderRefundPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(OrderRefundPO po) {
        log.info("create order_refund id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(OrderRefundPO po) {
        log.info("update order_refund id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete order_refund id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
