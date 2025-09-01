/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.FloorService;
import com.cybercafe.repository.mapper.FloorMapper;
import com.cybercafe.domain.po.FloorPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.FloorQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 楼层 服务实现。 */
@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorMapper mapper;

    @Override
    public IPage<FloorPO> listPage(FloorQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<FloorPO> listAll(FloorQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public FloorPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
