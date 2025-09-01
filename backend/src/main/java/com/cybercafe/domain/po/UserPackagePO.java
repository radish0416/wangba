/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户持有套餐 实体。
 */
@Data
@TableName("user_package")
public class UserPackagePO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 套餐ID */
    private Long packageId;

    /** 剩余时间(秒) */
    private Integer remainTimeSec;

    /** 剩余次数 */
    private Integer remainCount;

    /** 有效期至 */
    private LocalDateTime validTo;

    /** 状态 0禁用 1启用 */
    private Integer status;

    /** 来源订单ID */
    private Long orderId;

}
