/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.MemberLevelPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.MemberLevelQueryDTO;

/** 会员等级 Mapper。 */
public interface MemberLevelMapper extends BaseMapper<MemberLevelPO> {
    IPage<MemberLevelPO> selectByDynamic(Page<?> page, @Param("dto") MemberLevelQueryDTO dto);
    MemberLevelPO selectDetail(@Param("id") Long id);
}
