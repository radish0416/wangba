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
 * 支付回调日志 实体。
 */
@Data
@TableName("pay_notify_log")
public class PayNotifyLogPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 交易ID */
    private Long transactionId;

    /** 通知负载JSON */
    private String payload;

    /** 接收时间 */
    private LocalDateTime receivedTime;

}
