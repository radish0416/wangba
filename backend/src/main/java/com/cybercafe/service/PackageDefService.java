/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PackageDefPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PackageDefQueryDTO;

/** 套餐定义 服务。 */
public interface PackageDefService {
    /** 分页查询 */ IPage<PackageDefPO> listPage(PackageDefQueryDTO dto);
    /** 全量查询 */ java.util.List<PackageDefPO> listAll(PackageDefQueryDTO dto);
    /** 详情 */ PackageDefPO detail(Long id);
    /** 新增 */ Boolean create(PackageDefPO po);
    /** 修改 */ Boolean update(PackageDefPO po);
    /** 删除 */ Boolean delete(Long id);
}
