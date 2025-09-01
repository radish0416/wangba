/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 支付回调日志 视图对象。
 */
public class PayNotifyLogVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 交易ID */
    public Long transactionId;

    /** 通知负载JSON */
    public String payload;

    /** 接收时间 */
    public LocalDateTime receivedTime;

}
