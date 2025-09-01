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
    /** 分页查询 */ IPage<SysRolePermPO> listPage(SysRolePermQueryDTO dto);
    /** 全量查询 */ java.util.List<SysRolePermPO> listAll(SysRolePermQueryDTO dto);
    /** 详情 */ SysRolePermPO detail(Long id);
    /** 新增 */ Boolean create(SysRolePermPO po);
    /** 修改 */ Boolean update(SysRolePermPO po);
    /** 删除 */ Boolean delete(Long id);
}
