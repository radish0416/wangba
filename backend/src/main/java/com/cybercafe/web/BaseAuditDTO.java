package com.cybercafe.web;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

/**
 * 基础 DTO 字段（审计+扩展）。
 */
@Data
public class BaseAuditDTO {
    @Schema(description = "门店/租户ID")
    public Long storeId;
    @Schema(description = "创建人ID")
    public Long createBy;
    @Schema(description = "创建时间")
    public LocalDateTime createTime;
    @Schema(description = "修改人ID")
    public Long updateBy;
    @Schema(description = "修改时间")
    public LocalDateTime updateTime;
    @Schema(description = "扩展字段1")
    public String ext1;
    @Schema(description = "扩展字段2")
    public String ext2;
    @Schema(description = "扩展字段3")
    public String ext3;
    @Schema(description = "扩展字段4")
    public String ext4;
    @Schema(description = "扩展字段5")
    public String ext5;
}