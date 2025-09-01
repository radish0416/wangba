/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.ConsumeRecordPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.ConsumeRecordQueryDTO;

/** 消费记录 Mapper。 */
public interface ConsumeRecordMapper extends BaseMapper<ConsumeRecordPO> {
    IPage<ConsumeRecordPO> selectByDynamic(Page<?> page, @Param("dto") ConsumeRecordQueryDTO dto);
    ConsumeRecordPO selectDetail(@Param("id") Long id);
}
