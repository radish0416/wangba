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
 * 设备动作日志 查询入参。
 */
public class DeviceActionLogQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 机位ID */
    @Schema(description = "机位ID")
    public Long seatId;

    /** 动作 1开机 2关机 3续费 4查询 */
    @Schema(description = "动作 1开机 2关机 3续费 4查询")
    public Integer action;

    /** 请求负载JSON */
    @Schema(description = "请求负载JSON")
    public String requestPayload;

    /** 响应负载JSON */
    @Schema(description = "响应负载JSON")
    public String responsePayload;

    /** 是否成功 0否 1是 */
    @Schema(description = "是否成功 0否 1是")
    public Integer success;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
