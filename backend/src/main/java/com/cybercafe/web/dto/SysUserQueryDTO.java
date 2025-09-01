/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 后台账户 查询入参。
 */
public class SysUserQueryDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 门店/租户ID */
    @Schema(description = "门店/租户ID")
    public Long storeId;

    /** 用户名 */
    @Schema(description = "用户名")
    public String username;

    /** 密码哈希 */
    @Schema(description = "密码哈希")
    public String passwordHash;

    /** 显示名称 */
    @Schema(description = "显示名称")
    public String displayName;

    /** 状态 0禁用 1启用 */
    @Schema(description = "状态 0禁用 1启用")
    public Integer status;

    /** 创建人ID */
    @Schema(description = "创建人ID")
    public Long createBy;

    /** 创建时间 */
    @Schema(description = "创建时间")
    public LocalDateTime createTime;

    /** 修改人ID */
    @Schema(description = "修改人ID")
    public Long updateBy;

    /** 修改时间 */
    @Schema(description = "修改时间")
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    @Schema(description = "扩展字段1")
    public String ext1;

    /** 扩展字段2 */
    @Schema(description = "扩展字段2")
    public String ext2;

    /** 扩展字段3 */
    @Schema(description = "扩展字段3")
    public String ext3;

    /** 扩展字段4 */
    @Schema(description = "扩展字段4")
    public String ext4;

    /** 扩展字段5 */
    @Schema(description = "扩展字段5")
    public String ext5;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
