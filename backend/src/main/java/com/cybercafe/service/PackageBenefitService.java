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
    IPage<PackageBenefitPO> listPage(PackageBenefitQueryDTO dto);
    java.util.List<PackageBenefitPO> listAll(PackageBenefitQueryDTO dto);
    PackageBenefitPO detail(Long id);
}
