/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 帖子 查询入参。
 */
public class PostQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 标题 */
    @Schema(description = "标题")
    public String title;

    /** 内容 */
    @Schema(description = "内容")
    public String content;

    /** 作者ID */
    @Schema(description = "作者ID")
    public Long authorId;

    /** 状态 0下线 1上线 */
    @Schema(description = "状态 0下线 1上线")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

