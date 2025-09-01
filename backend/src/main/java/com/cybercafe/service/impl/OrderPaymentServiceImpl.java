/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.OrderPaymentService;
import com.cybercafe.repository.mapper.OrderPaymentMapper;
import com.cybercafe.domain.po.OrderPaymentPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderPaymentQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 订单支付记录 服务实现。 */
@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {
    @Autowired
    private OrderPaymentMapper mapper;

    @Override
    public IPage<OrderPaymentPO> listPage(OrderPaymentQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<OrderPaymentPO> listAll(OrderPaymentQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public OrderPaymentPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
