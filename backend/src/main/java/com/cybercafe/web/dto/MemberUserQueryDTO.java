/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 用户会员记录 查询入参。
 */
public class MemberUserQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 等级ID */
    @Schema(description = "等级ID")
    public Long levelId;

    /** 生效时间 */
    @Schema(description = "生效时间")
    public LocalDateTime validFrom;

    /** 失效时间 */
    @Schema(description = "失效时间")
    public LocalDateTime validTo;

    /** 状态 0禁用 1启用 */
    @Schema(description = "状态 0禁用 1启用")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
