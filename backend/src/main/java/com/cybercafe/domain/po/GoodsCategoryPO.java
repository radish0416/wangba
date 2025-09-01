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
 * 商品类目 实体。
 */
@Data
@TableName("goods_category")
public class GoodsCategoryPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 类目名称 */
    private String name;

    /** 上级类目ID */
    private Long parentId;

    /** 排序 */
    private Integer sort;

    /** 状态 0停用 1启用 */
    private Integer status;

}
