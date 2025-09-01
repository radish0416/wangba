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
    IPage<SysUserPO> listPage(SysUserQueryDTO dto);
    java.util.List<SysUserPO> listAll(SysUserQueryDTO dto);
    SysUserPO detail(Long id);
}
