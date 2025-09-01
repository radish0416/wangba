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
 * 字典类型 实体。
 */
@Data
@TableName("dict_type")
public class DictTypePO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 字典编码 */
    private String code;

    /** 字典名称 */
    private String name;

}
