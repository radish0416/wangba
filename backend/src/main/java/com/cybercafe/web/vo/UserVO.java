/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;

/**
 * 用户 视图对象。
 */
public class UserVO {
    /** 主键ID */
    public Long id;

    /** 门店/租户ID */
    public Long storeId;

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

    /** 创建人ID */
    public Long createBy;

    /** 创建时间 */
    public LocalDateTime createTime;

    /** 修改人ID */
    public Long updateBy;

    /** 修改时间 */
    public LocalDateTime updateTime;

    /** 扩展字段1 */
    public String ext1;

    /** 扩展字段2 */
    public String ext2;

    /** 扩展字段3 */
    public String ext3;

    /** 扩展字段4 */
    public String ext4;

    /** 扩展字段5 */
    public String ext5;

}
