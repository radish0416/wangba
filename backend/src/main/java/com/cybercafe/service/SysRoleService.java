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
    /** 分页查询 */ IPage<SysRolePO> listPage(SysRoleQueryDTO dto);
    /** 全量查询 */ java.util.List<SysRolePO> listAll(SysRoleQueryDTO dto);
    /** 详情 */ SysRolePO detail(Long id);
    /** 新增 */ Boolean create(SysRolePO po);
    /** 修改 */ Boolean update(SysRolePO po);
    /** 删除 */ Boolean delete(Long id);
}
