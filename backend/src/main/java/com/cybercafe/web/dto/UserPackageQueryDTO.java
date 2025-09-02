/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 用户持有套餐 查询入参。
 */
public class UserPackageQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 套餐ID */
    @Schema(description = "套餐ID")
    public Long packageId;

    /** 剩余时间(秒) */
    @Schema(description = "剩余时间(秒)")
    public Integer remainTimeSec;

    /** 剩余次数 */
    @Schema(description = "剩余次数")
    public Integer remainCount;

    /** 有效期至 */
    @Schema(description = "有效期至")
    public LocalDateTime validTo;

    /** 状态 0禁用 1启用 */
    @Schema(description = "状态 0禁用 1启用")
    public Integer status;

    /** 来源订单ID */
    @Schema(description = "来源订单ID")
    public Long orderId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

