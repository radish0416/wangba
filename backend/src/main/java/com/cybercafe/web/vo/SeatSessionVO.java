/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 机位会话 视图对象。
 */
public class SeatSessionVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 机位ID */
    public Long seatId;

    /** 用户ID */
    public Long userId;

    /** 订单ID */
    public Long orderId;

    /** 开始时间 */
    public LocalDateTime startTime;

    /** 结束时间 */
    public LocalDateTime endTime;

    /** 累计时长(秒) */
    public Integer durationSec;

    /** 状态 1进行中 2结束 3取消 */
    public Integer status;

}
