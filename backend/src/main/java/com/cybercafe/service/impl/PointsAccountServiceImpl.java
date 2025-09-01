/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PointsAccountService;
import com.cybercafe.repository.mapper.PointsAccountMapper;
import com.cybercafe.domain.po.PointsAccountPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PointsAccountQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 积分账户 服务实现。 */
@Service
public class PointsAccountServiceImpl implements PointsAccountService {
    @Autowired
    private PointsAccountMapper mapper;

    @Override
    public IPage<PointsAccountPO> listPage(PointsAccountQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PointsAccountPO> listAll(PointsAccountQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PointsAccountPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
