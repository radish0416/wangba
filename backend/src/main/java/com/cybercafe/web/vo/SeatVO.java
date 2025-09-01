/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
import java.time.LocalDateTime;
import java.time.LocalDateTime;
package com.cybercafe.web.vo;
import com.cybercafe.web.BaseAuditVO;

/**
 * 机位 视图对象。
 */
public class SeatVO extends BaseAuditVO {
    /** 主键ID */
    public Long id;

    /** 区域ID */
    public Long areaId;

    /** 设备编号 */
    public String deviceNo;

    /** 状态 1空闲 2占用 3故障 */
    public Integer status;

}
