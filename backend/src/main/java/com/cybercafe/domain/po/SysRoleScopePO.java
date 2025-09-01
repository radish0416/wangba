/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import lombok.Data;

/**
 * 角色-数据范围 实体。
 */
@Data
@TableName("sys_role_scope")
public class SysRoleScopePO extends BaseAuditPO {
    /** 角色ID */
    private Long roleId;

    /** 范围ID */
    private Long scopeId;

}
