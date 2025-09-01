/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PackageBenefitPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PackageBenefitQueryDTO;

/** 套餐权益 服务。 */
public interface PackageBenefitService {
    /** 分页查询 */ IPage<PackageBenefitPO> listPage(PackageBenefitQueryDTO dto);
    /** 全量查询 */ java.util.List<PackageBenefitPO> listAll(PackageBenefitQueryDTO dto);
    /** 详情 */ PackageBenefitPO detail(Long id);
    /** 新增 */ Boolean create(PackageBenefitPO po);
    /** 修改 */ Boolean update(PackageBenefitPO po);
    /** 删除 */ Boolean delete(Long id);
}
