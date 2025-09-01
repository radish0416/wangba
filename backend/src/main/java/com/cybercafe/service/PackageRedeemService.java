/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PackageRedeemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PackageRedeemQueryDTO;

/** 套餐核销记录 服务。 */
public interface PackageRedeemService {
    IPage<PackageRedeemPO> listPage(PackageRedeemQueryDTO dto);
    java.util.List<PackageRedeemPO> listAll(PackageRedeemQueryDTO dto);
    PackageRedeemPO detail(Long id);
}
