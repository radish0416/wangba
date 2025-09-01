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
 * 活动 实体。
 */
@Data
@TableName("campaign")
public class CampaignPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 活动名称 */
    private String name;

    /** 类型 1折扣 2满减 3限时 */
    private Integer type;

    /** 状态 0草稿 1生效 2下线 */
    private Integer status;

    /** 开始时间 */
    private LocalDateTime startTime;

    /** 结束时间 */
    private LocalDateTime endTime;

    /** 规则JSON */
    private String rules;

}
