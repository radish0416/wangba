/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysDataScopeService;
import com.cybercafe.repository.mapper.SysDataScopeMapper;
import com.cybercafe.domain.po.SysDataScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysDataScopeQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 数据范围定义 服务实现。 */
@Service
public class SysDataScopeServiceImpl implements SysDataScopeService {
    private static final Logger log = LoggerFactory.getLogger(SysDataScopeServiceImpl.class);
    @Resource
    private SysDataScopeMapper mapper;

    @Override
    public IPage<SysDataScopePO> listPage(SysDataScopeQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysDataScopePO> listAll(SysDataScopeQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysDataScopePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysDataScopePO po) {
        log.info("create sys_data_scope id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysDataScopePO po) {
        log.info("update sys_data_scope id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_data_scope id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
