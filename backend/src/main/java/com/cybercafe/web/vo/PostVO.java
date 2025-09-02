/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 帖子 视图对象。
 */
public class PostVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 标题 */
    public String title;

    /** 内容 */
    public String content;

    /** 作者ID */
    public Long authorId;

    /** 状态 0下线 1上线 */
    public Integer status;

}

