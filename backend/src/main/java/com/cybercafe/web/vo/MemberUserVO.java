/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 用户会员记录 视图对象。
 */
public class MemberUserVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 等级ID */
    public Long levelId;

    /** 生效时间 */
    public LocalDateTime validFrom;

    /** 失效时间 */
    public LocalDateTime validTo;

    /** 状态 0禁用 1启用 */
    public Integer status;

}

