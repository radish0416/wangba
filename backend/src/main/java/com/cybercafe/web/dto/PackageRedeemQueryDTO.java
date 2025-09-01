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
 * 套餐核销记录 查询入参。
 */
public class PackageRedeemQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 持有记录ID */
    @Schema(description = "持有记录ID")
    public Long userPackageId;

    /** 核销类型 1时间 2次数 */
    @Schema(description = "核销类型 1时间 2次数")
    public Integer redeemType;

    /** 核销值 */
    @Schema(description = "核销值")
    public Integer redeemValue;

    /** 关联订单ID */
    @Schema(description = "关联订单ID")
    public Long orderId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
