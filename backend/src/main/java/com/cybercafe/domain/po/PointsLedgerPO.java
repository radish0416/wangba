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
 * 积分流水 实体。
 */
@Data
@TableName("points_ledger")
public class PointsLedgerPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 积分增减值 */
    private Integer delta;

    /** 场景 earn|consume|adjust */
    private String scene;

    /** 业务单号 */
    private String bizId;

    /** 备注 */
    private String remark;

}
