/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户-角色 实体。
 */
@Data
@TableName("sys_user_role")
public class SysUserRolePO {
    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;

}
