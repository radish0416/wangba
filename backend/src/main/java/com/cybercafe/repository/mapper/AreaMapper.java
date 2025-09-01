/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.AreaPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.AreaQueryDTO;

/** 区域 Mapper。 */
public interface AreaMapper extends BaseMapper<AreaPO> {
    IPage<AreaPO> selectByDynamic(Page<?> page, @Param("dto") AreaQueryDTO dto);
    AreaPO selectDetail(@Param("id") Long id);
}
