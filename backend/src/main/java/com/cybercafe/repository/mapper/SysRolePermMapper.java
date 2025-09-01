/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.SysRolePermPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.SysRolePermQueryDTO;

/** 角色-权限 Mapper。 */
public interface SysRolePermMapper extends BaseMapper<SysRolePermPO> {
    IPage<SysRolePermPO> selectByDynamic(Page<?> page, @Param("dto") SysRolePermQueryDTO dto);
    SysRolePermPO selectDetail(@Param("id") Long id);
}
