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
 * 文件对象 实体。
 */
@Data
@TableName("file_object")
public class FileObjectPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 桶名 */
    private String bucket;

    /** 对象Key */
    private String objectKey;

    /** 内容类型 */
    private String contentType;

    /** 大小(byte) */
    private Long size;

}
