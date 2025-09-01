/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 文件对象 视图对象。
 */
public class FileObjectVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 桶名 */
    public String bucket;

    /** 对象Key */
    public String objectKey;

    /** 内容类型 */
    public String contentType;

    /** 大小(byte) */
    public Long size;

}
