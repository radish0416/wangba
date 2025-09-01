/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysRolePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRoleQueryDTO;

/** 角色 服务。 */
public interface SysRoleService {
    IPage<SysRolePO> listPage(SysRoleQueryDTO dto);
    java.util.List<SysRolePO> listAll(SysRoleQueryDTO dto);
    SysRolePO detail(Long id);
}
