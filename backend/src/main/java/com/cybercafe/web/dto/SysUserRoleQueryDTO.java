/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 用户-角色 查询入参。
 */
public class SysUserRoleQueryDTO extends BaseAuditDTO {
    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 角色ID */
    @Schema(description = "角色ID")
    public Long roleId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
