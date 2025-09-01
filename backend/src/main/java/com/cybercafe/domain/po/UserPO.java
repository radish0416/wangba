/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户 实体。
 */
@Data
@TableName("user")
public class UserPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 门店/租户ID */
    private Long storeId;

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

    /** 创建人ID */
    private Long createBy;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改人ID */
    private Long updateBy;

    /** 修改时间 */
    private LocalDateTime updateTime;

    /** 扩展字段1 */
    private String ext1;

    /** 扩展字段2 */
    private String ext2;

    /** 扩展字段3 */
    private String ext3;

    /** 扩展字段4 */
    private String ext4;

    /** 扩展字段5 */
    private String ext5;

}
