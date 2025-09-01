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
import org.springframework.beans.factory.annotation.Autowired;

/** 用户-角色 服务实现。 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
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
}
