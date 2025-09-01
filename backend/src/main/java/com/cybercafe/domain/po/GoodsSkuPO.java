/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 商品SKU 实体。
 */
@Data
@TableName("goods_sku")
public class GoodsSkuPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 商品ID */
    private Long goodsId;

    /** SKU编码 */
    private String skuCode;

    /** 售价 */
    private BigDecimal price;

    /** 状态 0停用 1启用 */
    private Integer status;

}
