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
 * 套餐权益 查询入参。
 */
public class PackageBenefitQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 套餐ID */
    @Schema(description = "套餐ID")
    public Long packageId;

    /** 权益键，如extraTime,discount */
    @Schema(description = "权益键，如extraTime,discount")
    public String benefitKey;

    /** 权益值 */
    @Schema(description = "权益值")
    public String benefitValue;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
