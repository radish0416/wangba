/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 角色-数据范围 查询入参。
 */
public class SysRoleScopeQueryDTO {
    /** 角色ID */
    @Schema(description = "角色ID")
    public Long roleId;

    /** 范围ID */
    @Schema(description = "范围ID")
    public Long scopeId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
