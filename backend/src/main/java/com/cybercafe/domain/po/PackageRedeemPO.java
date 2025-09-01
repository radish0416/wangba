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
 * 套餐核销记录 实体。
 */
@Data
@TableName("package_redeem")
public class PackageRedeemPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 持有记录ID */
    private Long userPackageId;

    /** 核销类型 1时间 2次数 */
    private Integer redeemType;

    /** 核销值 */
    private Integer redeemValue;

    /** 关联订单ID */
    private Long orderId;

}
