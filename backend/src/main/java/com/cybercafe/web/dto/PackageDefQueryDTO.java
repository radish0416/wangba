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
 * 套餐定义 查询入参。
 */
public class PackageDefQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 套餐名称 */
    @Schema(description = "套餐名称")
    public String name;

    /** 类型 1时间 2次数 3混合 */
    @Schema(description = "类型 1时间 2次数 3混合")
    public Integer type;

    /** 售价 */
    @Schema(description = "售价")
    public BigDecimal price;

    /** 有效天数 0表示不限 */
    @Schema(description = "有效天数 0表示不限")
    public Integer validDays;

    /** 状态 0下架 1上架 */
    @Schema(description = "状态 0下架 1上架")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

