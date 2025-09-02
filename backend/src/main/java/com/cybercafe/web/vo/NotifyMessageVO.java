/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 站内消息 视图对象。
 */
public class NotifyMessageVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 标题 */
    public String title;

    /** 内容 */
    public String content;

    /** 状态 0未读 1已读 */
    public Integer status;

}

