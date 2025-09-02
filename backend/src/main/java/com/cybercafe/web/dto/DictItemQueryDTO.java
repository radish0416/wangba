/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 字典项 查询入参。
 */
public class DictItemQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 类型ID */
    @Schema(description = "类型ID")
    public Long typeId;

    /** 显示文本 */
    @Schema(description = "显示文本")
    public String label;

    /** 值 */
    @Schema(description = "值")
    public String value;

    /** 排序 */
    @Schema(description = "排序")
    public Integer sort;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

