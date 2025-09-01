/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.CampaignSkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.CampaignSkuQueryDTO;

/** 活动适用SKU 服务。 */
public interface CampaignSkuService {
    /** 分页查询 */ IPage<CampaignSkuPO> listPage(CampaignSkuQueryDTO dto);
    /** 全量查询 */ java.util.List<CampaignSkuPO> listAll(CampaignSkuQueryDTO dto);
    /** 详情 */ CampaignSkuPO detail(Long id);
    /** 新增 */ Boolean create(CampaignSkuPO po);
    /** 修改 */ Boolean update(CampaignSkuPO po);
    /** 删除 */ Boolean delete(Long id);
}
