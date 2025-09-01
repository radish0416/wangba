/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysPermPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysPermQueryDTO;

/** 权限点 服务。 */
public interface SysPermService {
    IPage<SysPermPO> listPage(SysPermQueryDTO dto);
    java.util.List<SysPermPO> listAll(SysPermQueryDTO dto);
    SysPermPO detail(Long id);
}
