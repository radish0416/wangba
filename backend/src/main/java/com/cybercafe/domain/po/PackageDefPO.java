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
 * 套餐定义 实体。
 */
@Data
@TableName("package_def")
public class PackageDefPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 套餐名称 */
    private String name;

    /** 类型 1时间 2次数 3混合 */
    private Integer type;

    /** 售价 */
    private BigDecimal price;

    /** 有效天数 0表示不限 */
    private Integer validDays;

    /** 状态 0下架 1上架 */
    private Integer status;

}
