/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 商品SKU 视图对象。
 */
public class GoodsSkuVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 商品ID */
    public Long goodsId;

    /** SKU编码 */
    public String skuCode;

    /** 售价 */
    public BigDecimal price;

    /** 状态 0停用 1启用 */
    public Integer status;

}

