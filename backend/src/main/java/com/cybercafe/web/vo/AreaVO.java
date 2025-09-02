/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 区域 视图对象。
 */
public class AreaVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 楼层ID */
    public Long floorId;

    /** 区域名称 */
    public String name;

    /** 排序 */
    public Integer sort;

    /** 状态 0停用 1启用 */
    public Integer status;

}

