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
 * 数据范围定义 实体。
 */
@Data
@TableName("sys_data_scope")
public class SysDataScopePO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 范围名称 */
    private String name;

    /** 范围规则 1全部 2本门店 3本人 */
    private Integer scopeRule;

}
