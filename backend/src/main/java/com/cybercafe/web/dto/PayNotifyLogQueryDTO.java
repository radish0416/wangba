/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 支付回调日志 查询入参。
 */
public class PayNotifyLogQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 交易ID */
    @Schema(description = "交易ID")
    public Long transactionId;

    /** 通知负载JSON */
    @Schema(description = "通知负载JSON")
    public String payload;

    /** 接收时间 */
    @Schema(description = "接收时间")
    public LocalDateTime receivedTime;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
