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
 * 积分流水 查询入参。
 */
public class PointsLedgerQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 积分增减值 */
    @Schema(description = "积分增减值")
    public Integer delta;

    /** 场景 earn|consume|adjust */
    @Schema(description = "场景 earn|consume|adjust")
    public String scene;

    /** 业务单号 */
    @Schema(description = "业务单号")
    public String bizId;

    /** 备注 */
    @Schema(description = "备注")
    public String remark;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
