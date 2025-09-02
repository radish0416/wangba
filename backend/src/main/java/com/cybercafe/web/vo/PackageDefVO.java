/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.vo;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.cybercafe.web.BaseAuditVO;

/**
 * 套餐定义 视图对象。
 */
public class PackageDefVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 套餐名称 */
    public String name;

    /** 类型 1时间 2次数 3混合 */
    public Integer type;

    /** 售价 */
    public BigDecimal price;

    /** 有效天数 0表示不限 */
    public Integer validDays;

    /** 状态 0下架 1上架 */
    public Integer status;

}

