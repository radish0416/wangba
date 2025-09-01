/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysRoleService;
import com.cybercafe.repository.mapper.SysRoleMapper;
import com.cybercafe.domain.po.SysRolePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRoleQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 角色 服务实现。 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    private static final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);
    @Resource
    private SysRoleMapper mapper;

    @Override
    public IPage<SysRolePO> listPage(SysRoleQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysRolePO> listAll(SysRoleQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysRolePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysRolePO po) {
        log.info("create sys_role id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysRolePO po) {
        log.info("update sys_role id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_role id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
