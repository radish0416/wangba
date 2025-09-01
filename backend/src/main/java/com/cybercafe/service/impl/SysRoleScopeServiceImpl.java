/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysRoleScopeService;
import com.cybercafe.repository.mapper.SysRoleScopeMapper;
import com.cybercafe.domain.po.SysRoleScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRoleScopeQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 角色-数据范围 服务实现。 */
@Service
public class SysRoleScopeServiceImpl implements SysRoleScopeService {
    private static final Logger log = LoggerFactory.getLogger(SysRoleScopeServiceImpl.class);
    @Resource
    private SysRoleScopeMapper mapper;

    @Override
    public IPage<SysRoleScopePO> listPage(SysRoleScopeQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysRoleScopePO> listAll(SysRoleScopeQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysRoleScopePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysRoleScopePO po) {
        log.info("create sys_role_scope id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysRoleScopePO po) {
        log.info("update sys_role_scope id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_role_scope id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
