package com.cybercafe.web;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 基础 VO 字段（审计+扩展）。
 */
@Data
public class BaseAuditVO {
    /** 门店/租户ID */
    public Long storeId;
    /** 创建人ID */
    public Long createBy;
    /** 创建时间 */
    public LocalDateTime createTime;
    /** 修改人ID */
    public Long updateBy;
    /** 修改时间 */
    public LocalDateTime updateTime;
    /** 扩展字段1 */
    public String ext1;
    /** 扩展字段2 */
    public String ext2;
    /** 扩展字段3 */
    public String ext3;
    /** 扩展字段4 */
    public String ext4;
    /** 扩展字段5 */
    public String ext5;
}