/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.StatsDailyRevenueService;
import com.cybercafe.repository.mapper.StatsDailyRevenueMapper;
import com.cybercafe.domain.po.StatsDailyRevenuePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.StatsDailyRevenueQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 每日营收汇总 服务实现。 */
@Service
public class StatsDailyRevenueServiceImpl implements StatsDailyRevenueService {
    private static final Logger log = LoggerFactory.getLogger(StatsDailyRevenueServiceImpl.class);
    @Resource
    private StatsDailyRevenueMapper mapper;

    @Override
    public IPage<StatsDailyRevenuePO> listPage(StatsDailyRevenueQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<StatsDailyRevenuePO> listAll(StatsDailyRevenueQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public StatsDailyRevenuePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(StatsDailyRevenuePO po) {
        log.info("create stats_daily_revenue id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(StatsDailyRevenuePO po) {
        log.info("update stats_daily_revenue id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete stats_daily_revenue id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
