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
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 积分账户 服务实现。 */
@Service
public class PointsAccountServiceImpl implements PointsAccountService {
    private static final Logger log = LoggerFactory.getLogger(PointsAccountServiceImpl.class);
    @Resource
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

    @Override
    public Boolean create(PointsAccountPO po) {
        log.info("create points_account id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(PointsAccountPO po) {
        log.info("update points_account id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete points_account id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
