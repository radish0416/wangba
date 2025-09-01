/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.StatsDailyRevenuePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.StatsDailyRevenueQueryDTO;

/** 每日营收汇总 服务。 */
public interface StatsDailyRevenueService {
    IPage<StatsDailyRevenuePO> listPage(StatsDailyRevenueQueryDTO dto);
    java.util.List<StatsDailyRevenuePO> listAll(StatsDailyRevenueQueryDTO dto);
    StatsDailyRevenuePO detail(Long id);
}
