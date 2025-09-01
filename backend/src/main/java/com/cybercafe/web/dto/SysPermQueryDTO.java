/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 权限点 查询入参。
 */
public class SysPermQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 权限键 */
    @Schema(description = "权限键")
    public String permKey;

    /** 描述 */
    @Schema(description = "描述")
    public String desc;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
