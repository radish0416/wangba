/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 活动 查询入参。
 */
public class CampaignQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 活动名称 */
    @Schema(description = "活动名称")
    public String name;

    /** 类型 1折扣 2满减 3限时 */
    @Schema(description = "类型 1折扣 2满减 3限时")
    public Integer type;

    /** 状态 0草稿 1生效 2下线 */
    @Schema(description = "状态 0草稿 1生效 2下线")
    public Integer status;

    /** 开始时间 */
    @Schema(description = "开始时间")
    public LocalDateTime startTime;

    /** 结束时间 */
    @Schema(description = "结束时间")
    public LocalDateTime endTime;

    /** 规则JSON */
    @Schema(description = "规则JSON")
    public String rules;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
