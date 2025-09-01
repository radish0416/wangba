/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 用户 视图对象。
 */
public class UserVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 昵称 */
    public String nickname;

    /** 手机号 */
    public String mobile;

    /** 头像URL */
    public String avatarUrl;

    /** 性别 0未知 1男 2女 */
    public Integer gender;

    /** 状态 0禁用 1启用 */
    public Integer status;

    /** 微信openid */
    public String wechatOpenid;

    /** 微信unionid */
    public String wechatUnionid;

    /** 会员等级ID（快照） */
    public Long levelId;

}
