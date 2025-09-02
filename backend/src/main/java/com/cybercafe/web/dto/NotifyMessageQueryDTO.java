/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 站内消息 查询入参。
 */
public class NotifyMessageQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 用户ID */
    @Schema(description = "用户ID")
    public Long userId;

    /** 标题 */
    @Schema(description = "标题")
    public String title;

    /** 内容 */
    @Schema(description = "内容")
    public String content;

    /** 状态 0未读 1已读 */
    @Schema(description = "状态 0未读 1已读")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

