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
 * 设备动作日志 实体。
 */
@Data
@TableName("device_action_log")
public class DeviceActionLogPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 机位ID */
    private Long seatId;

    /** 动作 1开机 2关机 3续费 4查询 */
    private Integer action;

    /** 请求负载JSON */
    private String requestPayload;

    /** 响应负载JSON */
    private String responsePayload;

    /** 是否成功 0否 1是 */
    private Integer success;

}
