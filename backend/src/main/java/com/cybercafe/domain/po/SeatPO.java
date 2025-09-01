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
 * 机位 实体。
 */
@Data
@TableName("seat")
public class SeatPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 区域ID */
    private Long areaId;

    /** 设备编号 */
    private String deviceNo;

    /** 状态 1空闲 2占用 3故障 */
    private Integer status;

}
