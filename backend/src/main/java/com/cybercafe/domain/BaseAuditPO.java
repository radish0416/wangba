package com.cybercafe.domain;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 基础持久对象字段（审计+扩展）。
 * 包含门店/租户与创建/修改及扩展位。
 */
@Data
public class BaseAuditPO {

    private Long id;
    /** 门店/租户ID */
    private Long storeId;
    /** 创建人ID */
    private Long createBy;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 修改人ID */
    private Long updateBy;
    /** 修改时间 */
    private LocalDateTime updateTime;
    /** 扩展字段1 */
    private String ext1;
    /** 扩展字段2 */
    private String ext2;
    /** 扩展字段3 */
    private String ext3;
    /** 扩展字段4 */
    private String ext4;
    /** 扩展字段5 */
    private String ext5;
}