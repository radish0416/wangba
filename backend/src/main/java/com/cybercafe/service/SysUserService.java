/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysUserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysUserQueryDTO;

/** 后台账户 服务。 */
public interface SysUserService {
    /** 分页查询 */ IPage<SysUserPO> listPage(SysUserQueryDTO dto);
    /** 全量查询 */ java.util.List<SysUserPO> listAll(SysUserQueryDTO dto);
    /** 详情 */ SysUserPO detail(Long id);
    /** 新增 */ Boolean create(SysUserPO po);
    /** 修改 */ Boolean update(SysUserPO po);
    /** 删除 */ Boolean delete(Long id);
}
