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
 * 会员等级 实体。
 */
@Data
@TableName("member_level")
public class MemberLevelPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 等级名称 */
    private String name;

    /** 达标积分 */
    private Integer minPoints;

    /** 折扣(百分比) */
    private BigDecimal discountRate;

    /** 权益列表JSON */
    private String benefits;

    /** 状态 0禁用 1启用 */
    private Integer status;

}
