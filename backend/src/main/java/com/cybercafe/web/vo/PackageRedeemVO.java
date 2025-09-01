/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 套餐核销记录 视图对象。
 */
public class PackageRedeemVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 持有记录ID */
    public Long userPackageId;

    /** 核销类型 1时间 2次数 */
    public Integer redeemType;

    /** 核销值 */
    public Integer redeemValue;

    /** 关联订单ID */
    public Long orderId;

}
