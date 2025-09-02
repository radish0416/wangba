/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 角色 查询入参。
 */
public class SysRoleQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 角色名称 */
    @Schema(description = "角色名称")
    public String name;

    /** 数据范围 1全部 2本门店 3本人 */
    @Schema(description = "数据范围 1全部 2本门店 3本人")
    public Integer dataScope;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

