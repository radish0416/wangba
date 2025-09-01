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
 * 区域 实体。
 */
@Data
@TableName("area")
public class AreaPO extends BaseAuditPO {
    @TableId
    /** 主键ID */
    private Long id;

    /** 楼层ID */
    private Long floorId;

    /** 区域名称 */
    private String name;

    /** 排序 */
    private Integer sort;

    /** 状态 0停用 1启用 */
    private Integer status;

}
