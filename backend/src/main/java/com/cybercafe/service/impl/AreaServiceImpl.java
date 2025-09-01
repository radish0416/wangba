/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.AreaService;
import com.cybercafe.repository.mapper.AreaMapper;
import com.cybercafe.domain.po.AreaPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.AreaQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 区域 服务实现。 */
@Service
public class AreaServiceImpl implements AreaService {
    private static final Logger log = LoggerFactory.getLogger(AreaServiceImpl.class);
    @Resource
    private AreaMapper mapper;

    @Override
    public IPage<AreaPO> listPage(AreaQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<AreaPO> listAll(AreaQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public AreaPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(AreaPO po) {
        log.info("create area id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(AreaPO po) {
        log.info("update area id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete area id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
