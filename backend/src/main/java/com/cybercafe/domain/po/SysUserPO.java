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
 * 后台账户 实体。
 */
@Data
@TableName("sys_user")
public class SysUserPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码哈希 */
    private String passwordHash;

    /** 显示名称 */
    private String displayName;

    /** 状态 0禁用 1启用 */
    private Integer status;

}
