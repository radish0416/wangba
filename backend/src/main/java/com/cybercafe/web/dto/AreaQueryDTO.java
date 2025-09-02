/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.dto;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import com.cybercafe.web.BaseAuditDTO;

/**
 * 区域 查询入参。
 */
public class AreaQueryDTO extends BaseAuditDTO {
    /** 主键ID */
    @Schema(description = "主键ID")
    public Long id;

    /** 楼层ID */
    @Schema(description = "楼层ID")
    public Long floorId;

    /** 区域名称 */
    @Schema(description = "区域名称")
    public String name;

    /** 排序 */
    @Schema(description = "排序")
    public Integer sort;

    /** 状态 0停用 1启用 */
    @Schema(description = "状态 0停用 1启用")
    public Integer status;

    /** 当前页 */
    public Long current;

    /** 每页大小 */
    public Long size;
}
