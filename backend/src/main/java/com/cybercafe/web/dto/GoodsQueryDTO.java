/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 商品 查询入参。
 */
public class GoodsQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 商品名称 */
    @Schema(description = "商品名称")
    public String name;

    /** 类目ID */
    @Schema(description = "类目ID")
    public Long categoryId;

    /** 商品类型 1计时 2计次 3耗材 4服务 */
    @Schema(description = "商品类型 1计时 2计次 3耗材 4服务")
    public Integer type;

    /** 状态 0下架 1上架 */
    @Schema(description = "状态 0下架 1上架")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

