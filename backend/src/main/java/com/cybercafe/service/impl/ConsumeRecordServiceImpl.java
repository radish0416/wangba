/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.ConsumeRecordService;
import com.cybercafe.repository.mapper.ConsumeRecordMapper;
import com.cybercafe.domain.po.ConsumeRecordPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.ConsumeRecordQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 消费记录 服务实现。 */
@Service
public class ConsumeRecordServiceImpl implements ConsumeRecordService {
    private static final Logger log = LoggerFactory.getLogger(ConsumeRecordServiceImpl.class);
    @Resource
    private ConsumeRecordMapper mapper;

    @Override
    public IPage<ConsumeRecordPO> listPage(ConsumeRecordQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<ConsumeRecordPO> listAll(ConsumeRecordQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public ConsumeRecordPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(ConsumeRecordPO po) {
        log.info("create consume_record id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(ConsumeRecordPO po) {
        log.info("update consume_record id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete consume_record id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
