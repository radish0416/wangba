/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.CampaignService;
import com.cybercafe.repository.mapper.CampaignMapper;
import com.cybercafe.domain.po.CampaignPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.CampaignQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 活动 服务实现。 */
@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignMapper mapper;

    @Override
    public IPage<CampaignPO> listPage(CampaignQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<CampaignPO> listAll(CampaignQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public CampaignPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
