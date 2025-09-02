/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 积分流水 视图对象。
 */
public class PointsLedgerVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 用户ID */
    public Long userId;

    /** 积分增减值 */
    public Integer delta;

    /** 场景 earn|consume|adjust */
    public String scene;

    /** 业务单号 */
    public String bizId;

    /** 备注 */
    public String remark;

}

