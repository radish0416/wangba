/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.StatsDailyRevenuePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.StatsDailyRevenueQueryDTO;

/** 每日营收汇总 Mapper。 */
public interface StatsDailyRevenueMapper extends BaseMapper<StatsDailyRevenuePO> {
    IPage<StatsDailyRevenuePO> selectByDynamic(Page<?> page, @Param("dto") StatsDailyRevenueQueryDTO dto);
    StatsDailyRevenuePO selectDetail(@Param("id") Long id);
}
