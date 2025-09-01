/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysUserRolePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysUserRoleQueryDTO;

/** 用户-角色 服务。 */
public interface SysUserRoleService {
    IPage<SysUserRolePO> listPage(SysUserRoleQueryDTO dto);
    java.util.List<SysUserRolePO> listAll(SysUserRoleQueryDTO dto);
    SysUserRolePO detail(Long id);
}
