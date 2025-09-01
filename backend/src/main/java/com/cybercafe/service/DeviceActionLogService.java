/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.DeviceActionLogPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DeviceActionLogQueryDTO;

/** 设备动作日志 服务。 */
public interface DeviceActionLogService {
    /** 分页查询 */ IPage<DeviceActionLogPO> listPage(DeviceActionLogQueryDTO dto);
    /** 全量查询 */ java.util.List<DeviceActionLogPO> listAll(DeviceActionLogQueryDTO dto);
    /** 详情 */ DeviceActionLogPO detail(Long id);
    /** 新增 */ Boolean create(DeviceActionLogPO po);
    /** 修改 */ Boolean update(DeviceActionLogPO po);
    /** 删除 */ Boolean delete(Long id);
}
