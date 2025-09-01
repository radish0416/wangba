/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.domain.po;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cybercafe.domain.BaseAuditPO;
import lombok.Data;

/**
 * 积分账户 实体。
 */
@Data
@TableName("points_account")
public class PointsAccountPO extends BaseAuditPO {
    /** 用户ID */
    private Long userId;

    /** 当前积分 */
    private Long balance;

}
