/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysUserRoleService;
import com.cybercafe.repository.mapper.SysUserRoleMapper;
import com.cybercafe.domain.po.SysUserRolePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysUserRoleQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 用户-角色 服务实现。 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    private static final Logger log = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);
    @Resource
    private SysUserRoleMapper mapper;

    @Override
    public IPage<SysUserRolePO> listPage(SysUserRoleQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysUserRolePO> listAll(SysUserRoleQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysUserRolePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysUserRolePO po) {
        log.info("create sys_user_role id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysUserRolePO po) {
        log.info("update sys_user_role id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_user_role id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
