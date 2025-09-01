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
 * 权限点 实体。
 */
@Data
@TableName("sys_perm")
public class SysPermPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 权限键 */
    private String permKey;

    /** 描述 */
    private String desc;

}
