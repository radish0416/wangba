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
 * 站内消息 实体。
 */
@Data
@TableName("notify_message")
public class NotifyMessagePO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 标题 */
    private String title;

    /** 内容 */
    private String content;

    /** 状态 0未读 1已读 */
    private Integer status;

}
