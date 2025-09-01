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
 * 积分账户 查询入参。
 */
public class PointsAccountQueryDTO extends BaseAuditDTO {
    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 当前积分 */
    @Schema(description = "当前积分")
    public Long balance;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
