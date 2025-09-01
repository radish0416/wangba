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
 * 评论 查询入参。
 */
public class CommentQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 帖子ID */
    @Schema(description = "帖子ID")
    public Long postId;

    /** 评论用户ID */
    @Schema(description = "评论用户ID")
    public Long userId;

    /** 评论内容 */
    @Schema(description = "评论内容")
    public String content;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
