/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.MemberUserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.MemberUserQueryDTO;

/** 用户会员记录 Mapper。 */
public interface MemberUserMapper extends BaseMapper<MemberUserPO> {
    IPage<MemberUserPO> selectByDynamic(Page<?> page, @Param("dto") MemberUserQueryDTO dto);
    MemberUserPO selectDetail(@Param("id") Long id);
}
