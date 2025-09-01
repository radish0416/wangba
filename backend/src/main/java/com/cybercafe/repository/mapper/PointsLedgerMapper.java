/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.PointsLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.PointsLedgerQueryDTO;

/** 积分流水 Mapper。 */
public interface PointsLedgerMapper extends BaseMapper<PointsLedgerPO> {
    IPage<PointsLedgerPO> selectByDynamic(Page<?> page, @Param("dto") PointsLedgerQueryDTO dto);
    PointsLedgerPO selectDetail(@Param("id") Long id);
}
