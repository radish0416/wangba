/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysRolePermPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRolePermQueryDTO;

/** 角色-权限 服务。 */
public interface SysRolePermService {
    IPage<SysRolePermPO> listPage(SysRolePermQueryDTO dto);
    java.util.List<SysRolePermPO> listAll(SysRolePermQueryDTO dto);
    SysRolePermPO detail(Long id);
}
