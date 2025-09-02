/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 字典项 视图对象。
 */
public class DictItemVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 类型ID */
    public Long typeId;

    /** 显示文本 */
    public String label;

    /** 值 */
    public String value;

    /** 排序 */
    public Integer sort;

}

