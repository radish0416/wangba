/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.NotifyMessageService;
import com.cybercafe.repository.mapper.NotifyMessageMapper;
import com.cybercafe.domain.po.NotifyMessagePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.NotifyMessageQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 站内消息 服务实现。 */
@Service
public class NotifyMessageServiceImpl implements NotifyMessageService {
    private static final Logger log = LoggerFactory.getLogger(NotifyMessageServiceImpl.class);
    @Resource
    private NotifyMessageMapper mapper;

    @Override
    public IPage<NotifyMessagePO> listPage(NotifyMessageQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<NotifyMessagePO> listAll(NotifyMessageQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public NotifyMessagePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(NotifyMessagePO po) {
        log.info("create notify_message id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(NotifyMessagePO po) {
        log.info("update notify_message id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete notify_message id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
