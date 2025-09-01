/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysRoleScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRoleScopeQueryDTO;

/** 角色-数据范围 服务。 */
public interface SysRoleScopeService {
    IPage<SysRoleScopePO> listPage(SysRoleScopeQueryDTO dto);
    java.util.List<SysRoleScopePO> listAll(SysRoleScopeQueryDTO dto);
    SysRoleScopePO detail(Long id);
}
