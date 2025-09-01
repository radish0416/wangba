/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 文件对象 查询入参。
 */
public class FileObjectQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 桶名 */
    @Schema(description = "桶名")
    public String bucket;

    /** 对象Key */
    @Schema(description = "对象Key")
    public String objectKey;

    /** 内容类型 */
    @Schema(description = "内容类型")
    public String contentType;

    /** 大小(byte) */
    @Schema(description = "大小(byte)")
    public Long size;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
