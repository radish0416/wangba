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
 * 字典项 实体。
 */
@Data
@TableName("dict_item")
public class DictItemPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 类型ID */
    private Long typeId;

    /** 显示文本 */
    private String label;

    /** 值 */
    private String value;

    /** 排序 */
    private Integer sort;

}
