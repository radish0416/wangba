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
 * 角色 实体。
 */
@Data
@TableName("sys_role")
public class SysRolePO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 角色名称 */
    private String name;

    /** 数据范围 1全部 2本门店 3本人 */
    private Integer dataScope;

}
