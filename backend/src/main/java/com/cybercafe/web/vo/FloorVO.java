/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 楼层 视图对象。
 */
public class FloorVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 楼层名称 */
    public String name;

    /** 排序 */
    public Integer sort;

    /** 状态 0停用 1启用 */
    public Integer status;

}
