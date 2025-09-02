/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 活动 视图对象。
 */
public class CampaignVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 活动名称 */
    public String name;

    /** 类型 1折扣 2满减 3限时 */
    public Integer type;

    /** 状态 0草稿 1生效 2下线 */
    public Integer status;

    /** 开始时间 */
    public LocalDateTime startTime;

    /** 结束时间 */
    public LocalDateTime endTime;

    /** 规则JSON */
    public String rules;

}

