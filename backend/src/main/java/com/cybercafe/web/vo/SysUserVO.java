/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 后台账户 视图对象。
 */
public class SysUserVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户名 */
    public String username;

    /** 密码哈希 */
    public String passwordHash;

    /** 显示名称 */
    public String displayName;

    /** 状态 0禁用 1启用 */
    public Integer status;

}
