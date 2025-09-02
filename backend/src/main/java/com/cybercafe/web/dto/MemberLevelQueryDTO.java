/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 会员等级 查询入参。
 */
public class MemberLevelQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 等级名称 */
    @Schema(description = "等级名称")
    public String name;

    /** 达标积分 */
    @Schema(description = "达标积分")
    public Integer minPoints;

    /** 折扣(百分比) */
    @Schema(description = "折扣(百分比)")
    public BigDecimal discountRate;

    /** 权益列表JSON */
    @Schema(description = "权益列表JSON")
    public String benefits;

    /** 状态 0禁用 1启用 */
    @Schema(description = "状态 0禁用 1启用")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

