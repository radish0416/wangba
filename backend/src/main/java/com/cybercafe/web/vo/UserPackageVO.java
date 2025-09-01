/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 用户持有套餐 视图对象。
 */
public class UserPackageVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 套餐ID */
    public Long packageId;

    /** 剩余时间(秒) */
    public Integer remainTimeSec;

    /** 剩余次数 */
    public Integer remainCount;

    /** 有效期至 */
    public LocalDateTime validTo;

    /** 状态 0禁用 1启用 */
    public Integer status;

    /** 来源订单ID */
    public Long orderId;

}
