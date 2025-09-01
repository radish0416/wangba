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
 * 用户 实体。
 */
@Data
@TableName("user")
public class UserPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 昵称 */
    private String nickname;

    /** 手机号 */
    private String mobile;

    /** 头像URL */
    private String avatarUrl;

    /** 性别 0未知 1男 2女 */
    private Integer gender;

    /** 状态 0禁用 1启用 */
    private Integer status;

    /** 微信openid */
    private String wechatOpenid;

    /** 微信unionid */
    private String wechatUnionid;

    /** 会员等级ID（快照） */
    private Long levelId;

}
