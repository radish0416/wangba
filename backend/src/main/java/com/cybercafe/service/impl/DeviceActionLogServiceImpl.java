/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.DeviceActionLogService;
import com.cybercafe.repository.mapper.DeviceActionLogMapper;
import com.cybercafe.domain.po.DeviceActionLogPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DeviceActionLogQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 设备动作日志 服务实现。 */
@Service
public class DeviceActionLogServiceImpl implements DeviceActionLogService {
    @Autowired
    private DeviceActionLogMapper mapper;

    @Override
    public IPage<DeviceActionLogPO> listPage(DeviceActionLogQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<DeviceActionLogPO> listAll(DeviceActionLogQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public DeviceActionLogPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
