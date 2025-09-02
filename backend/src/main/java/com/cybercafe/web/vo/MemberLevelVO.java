/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 会员等级 视图对象。
 */
public class MemberLevelVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 等级名称 */
    public String name;

    /** 达标积分 */
    public Integer minPoints;

    /** 折扣(百分比) */
    public BigDecimal discountRate;

    /** 权益列表JSON */
    public String benefits;

    /** 状态 0禁用 1启用 */
    public Integer status;

}

