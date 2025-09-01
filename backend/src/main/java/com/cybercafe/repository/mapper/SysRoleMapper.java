/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.SysRolePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.SysRoleQueryDTO;

/** 角色 Mapper。 */
public interface SysRoleMapper extends BaseMapper<SysRolePO> {
    IPage<SysRolePO> selectByDynamic(Page<?> page, @Param("dto") SysRoleQueryDTO dto);
    SysRolePO selectDetail(@Param("id") Long id);
}
