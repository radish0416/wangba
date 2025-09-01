/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PayTransactionService;
import com.cybercafe.repository.mapper.PayTransactionMapper;
import com.cybercafe.domain.po.PayTransactionPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PayTransactionQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 支付交易 服务实现。 */
@Service
public class PayTransactionServiceImpl implements PayTransactionService {
    @Autowired
    private PayTransactionMapper mapper;

    @Override
    public IPage<PayTransactionPO> listPage(PayTransactionQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PayTransactionPO> listAll(PayTransactionQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PayTransactionPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
