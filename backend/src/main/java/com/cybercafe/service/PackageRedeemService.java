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
    /** 分页查询 */ IPage<PackageRedeemPO> listPage(PackageRedeemQueryDTO dto);
    /** 全量查询 */ java.util.List<PackageRedeemPO> listAll(PackageRedeemQueryDTO dto);
    /** 详情 */ PackageRedeemPO detail(Long id);
    /** 新增 */ Boolean create(PackageRedeemPO po);
    /** 修改 */ Boolean update(PackageRedeemPO po);
    /** 删除 */ Boolean delete(Long id);
}
