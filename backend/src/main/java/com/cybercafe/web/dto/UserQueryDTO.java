/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 用户 查询入参。
 */
public class UserQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 昵称 */
    @Schema(description = "昵称")
    public String nickname;

    /** 手机号 */
    @Schema(description = "手机号")
    public String mobile;

    /** 头像URL */
    @Schema(description = "头像URL")
    public String avatarUrl;

    /** 性别 0未知 1男 2女 */
    @Schema(description = "性别 0未知 1男 2女")
    public Integer gender;

    /** 状态 0禁用 1启用 */
    @Schema(description = "状态 0禁用 1启用")
    public Integer status;

    /** 微信openid */
    @Schema(description = "微信openid")
    public String wechatOpenid;

    /** 微信unionid */
    @Schema(description = "微信unionid")
    public String wechatUnionid;

    /** 会员等级ID（快照） */
    @Schema(description = "会员等级ID（快照）")
    public Long levelId;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}

