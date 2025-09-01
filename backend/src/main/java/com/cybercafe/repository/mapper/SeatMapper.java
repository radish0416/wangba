/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.SeatPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.SeatQueryDTO;

/** 机位 Mapper。 */
public interface SeatMapper extends BaseMapper<SeatPO> {
    IPage<SeatPO> selectByDynamic(Page<?> page, @Param("dto") SeatQueryDTO dto);
    SeatPO selectDetail(@Param("id") Long id);
}
