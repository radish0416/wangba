/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SysDataScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysDataScopeQueryDTO;

/** 数据范围定义 服务。 */
public interface SysDataScopeService {
    IPage<SysDataScopePO> listPage(SysDataScopeQueryDTO dto);
    java.util.List<SysDataScopePO> listAll(SysDataScopeQueryDTO dto);
    SysDataScopePO detail(Long id);
}
