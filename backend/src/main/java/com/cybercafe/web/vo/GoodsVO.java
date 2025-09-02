/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import com.cybercafe.web.BaseAuditVO;

/**
 * 商品 视图对象。
 */
public class GoodsVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 商品名称 */
    public String name;

    /** 类目ID */
    public Long categoryId;

    /** 商品类型 1计时 2计次 3耗材 4服务 */
    public Integer type;

    /** 状态 0下架 1上架 */
    public Integer status;

}

