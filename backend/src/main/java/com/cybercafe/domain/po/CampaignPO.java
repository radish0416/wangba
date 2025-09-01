/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 活动 实体。
 */
@Data
@TableName("campaign")
public class CampaignPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 门店/租户ID */
    private Long storeId;

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

    /** 创建人ID */
    private Long createBy;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 修改人ID */
    private Long updateBy;

    /** 修改时间 */
    private LocalDateTime updateTime;

    /** 扩展字段1 */
    private String ext1;

    /** 扩展字段2 */
    private String ext2;

    /** 扩展字段3 */
    private String ext3;

    /** 扩展字段4 */
    private String ext4;

    /** 扩展字段5 */
    private String ext5;

}
