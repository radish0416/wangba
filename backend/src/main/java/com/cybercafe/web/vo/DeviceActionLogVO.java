/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 设备动作日志 视图对象。
 */
public class DeviceActionLogVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 机位ID */
    public Long seatId;

    /** 动作 1开机 2关机 3续费 4查询 */
    public Integer action;

    /** 请求负载JSON */
    public String requestPayload;

    /** 响应负载JSON */
    public String responsePayload;

    /** 是否成功 0否 1是 */
    public Integer success;

}
