/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 角色-权限 查询入参。
 */
public class SysRolePermQueryDTO {
    /** 角色ID */
    @Schema(description = "角色ID")
    public Long roleId;

    /** 权限点ID */
    @Schema(description = "权限点ID")
    public Long permId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
