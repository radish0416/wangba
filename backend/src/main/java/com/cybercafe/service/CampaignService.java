/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.CampaignPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.CampaignQueryDTO;

/** 活动 服务。 */
public interface CampaignService {
    IPage<CampaignPO> listPage(CampaignQueryDTO dto);
    java.util.List<CampaignPO> listAll(CampaignQueryDTO dto);
    CampaignPO detail(Long id);
}
