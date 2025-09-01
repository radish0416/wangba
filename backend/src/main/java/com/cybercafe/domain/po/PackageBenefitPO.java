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
 * 套餐权益 实体。
 */
@Data
@TableName("package_benefit")
public class PackageBenefitPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 套餐ID */
    private Long packageId;

    /** 权益键，如extraTime,discount */
    private String benefitKey;

    /** 权益值 */
    private String benefitValue;

}
