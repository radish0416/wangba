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
    IPage<PackageDefPO> listPage(PackageDefQueryDTO dto);
    java.util.List<PackageDefPO> listAll(PackageDefQueryDTO dto);
    PackageDefPO detail(Long id);
}
