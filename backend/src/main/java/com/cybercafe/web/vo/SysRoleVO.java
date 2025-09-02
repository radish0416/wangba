/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 角色 视图对象。
 */
public class SysRoleVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 角色名称 */
    public String name;

    /** 数据范围 1全部 2本门店 3本人 */
    public Integer dataScope;

}

