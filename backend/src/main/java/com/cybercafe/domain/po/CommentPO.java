/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import lombok.Data;

/**
 * 评论 实体。
 */
@Data
@TableName("comment")
public class CommentPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 帖子ID */
    private Long postId;

    /** 评论用户ID */
    private Long userId;

    /** 评论内容 */
    private String content;

}
