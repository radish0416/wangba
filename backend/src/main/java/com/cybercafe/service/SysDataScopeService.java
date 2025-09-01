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
    /** 分页查询 */ IPage<SysDataScopePO> listPage(SysDataScopeQueryDTO dto);
    /** 全量查询 */ java.util.List<SysDataScopePO> listAll(SysDataScopeQueryDTO dto);
    /** 详情 */ SysDataScopePO detail(Long id);
    /** 新增 */ Boolean create(SysDataScopePO po);
    /** 修改 */ Boolean update(SysDataScopePO po);
    /** 删除 */ Boolean delete(Long id);
}
