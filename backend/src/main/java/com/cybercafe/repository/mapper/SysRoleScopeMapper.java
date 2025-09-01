/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.SysRoleScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.SysRoleScopeQueryDTO;

/** 角色-数据范围 Mapper。 */
public interface SysRoleScopeMapper extends BaseMapper<SysRoleScopePO> {
    IPage<SysRoleScopePO> selectByDynamic(Page<?> page, @Param("dto") SysRoleScopeQueryDTO dto);
    SysRoleScopePO selectDetail(@Param("id") Long id);
}
