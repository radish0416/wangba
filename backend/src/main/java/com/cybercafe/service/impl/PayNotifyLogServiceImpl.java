/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PayNotifyLogService;
import com.cybercafe.repository.mapper.PayNotifyLogMapper;
import com.cybercafe.domain.po.PayNotifyLogPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PayNotifyLogQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 支付回调日志 服务实现。 */
@Service
public class PayNotifyLogServiceImpl implements PayNotifyLogService {
    private static final Logger log = LoggerFactory.getLogger(PayNotifyLogServiceImpl.class);
    @Resource
    private PayNotifyLogMapper mapper;

    @Override
    public IPage<PayNotifyLogPO> listPage(PayNotifyLogQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PayNotifyLogPO> listAll(PayNotifyLogQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PayNotifyLogPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(PayNotifyLogPO po) {
        log.info("create pay_notify_log id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(PayNotifyLogPO po) {
        log.info("update pay_notify_log id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete pay_notify_log id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
