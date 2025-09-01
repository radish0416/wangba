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
 * 机位会话 查询入参。
 */
public class SeatSessionQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 机位ID */
    @Schema(description = "机位ID")
    public Long seatId;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 订单ID */
    @Schema(description = "订单ID")
    public Long orderId;

    /** 开始时间 */
    @Schema(description = "开始时间")
    public LocalDateTime startTime;

    /** 结束时间 */
    @Schema(description = "结束时间")
    public LocalDateTime endTime;

    /** 累计时长(秒) */
    @Schema(description = "累计时长(秒)")
    public Integer durationSec;

    /** 状态 1进行中 2结束 3取消 */
    @Schema(description = "状态 1进行中 2结束 3取消")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
