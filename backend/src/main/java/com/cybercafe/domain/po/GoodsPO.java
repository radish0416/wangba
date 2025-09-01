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
 * 商品 实体。
 */
@Data
@TableName("goods")
public class GoodsPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 商品名称 */
    private String name;

    /** 类目ID */
    private Long categoryId;

    /** 商品类型 1计时 2计次 3耗材 4服务 */
    private Integer type;

    /** 状态 0下架 1上架 */
    private Integer status;

}
