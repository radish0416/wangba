/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 套餐权益 视图对象。
 */
public class PackageBenefitVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 套餐ID */
    public Long packageId;

    /** 权益键，如extraTime,discount */
    public String benefitKey;

    /** 权益值 */
    public String benefitValue;

}

