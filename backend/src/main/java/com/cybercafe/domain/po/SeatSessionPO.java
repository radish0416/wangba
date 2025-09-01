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
 * 机位会话 实体。
 */
@Data
@TableName("seat_session")
public class SeatSessionPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 机位ID */
    private Long seatId;

    /** 用户ID */
    private Long userId;

    /** 订单ID */
    private Long orderId;

    /** 开始时间 */
    private LocalDateTime startTime;

    /** 结束时间 */
    private LocalDateTime endTime;

    /** 累计时长(秒) */
    private Integer durationSec;

    /** 状态 1进行中 2结束 3取消 */
    private Integer status;

}
