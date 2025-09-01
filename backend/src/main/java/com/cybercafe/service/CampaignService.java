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
    /** 分页查询 */ IPage<CampaignPO> listPage(CampaignQueryDTO dto);
    /** 全量查询 */ java.util.List<CampaignPO> listAll(CampaignQueryDTO dto);
    /** 详情 */ CampaignPO detail(Long id);
    /** 新增 */ Boolean create(CampaignPO po);
    /** 修改 */ Boolean update(CampaignPO po);
    /** 删除 */ Boolean delete(Long id);
}
