/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 评论 视图对象。
 */
public class CommentVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 帖子ID */
    public Long postId;

    /** 评论用户ID */
    public Long userId;

    /** 评论内容 */
    public String content;

}

