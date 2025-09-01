/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PackageBenefitService;
import com.cybercafe.repository.mapper.PackageBenefitMapper;
import com.cybercafe.domain.po.PackageBenefitPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PackageBenefitQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 套餐权益 服务实现。 */
@Service
public class PackageBenefitServiceImpl implements PackageBenefitService {
    @Autowired
    private PackageBenefitMapper mapper;

    @Override
    public IPage<PackageBenefitPO> listPage(PackageBenefitQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PackageBenefitPO> listAll(PackageBenefitQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PackageBenefitPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
