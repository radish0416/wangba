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
 * 积分流水 实体。
 */
@Data
@TableName("points_ledger")
public class PointsLedgerPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 门店/租户ID */
    private Long storeId;

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
