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
 * 帖子 实体。
 */
@Data
@TableName("post")
public class PostPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 作者ID */
    private Long authorId;

    /** 状态 0下线 1上线 */
    private Integer status;

}
