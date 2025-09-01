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
 * 机位 查询入参。
 */
public class SeatQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 区域ID */
    @Schema(description = "区域ID")
    public Long areaId;

    /** 设备编号 */
    @Schema(description = "设备编号")
    public String deviceNo;

    /** 状态 1空闲 2占用 3故障 */
    @Schema(description = "状态 1空闲 2占用 3故障")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
