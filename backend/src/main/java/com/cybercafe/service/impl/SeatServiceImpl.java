/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SeatService;
import com.cybercafe.repository.mapper.SeatMapper;
import com.cybercafe.domain.po.SeatPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SeatQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 机位 服务实现。 */
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper mapper;

    @Override
    public IPage<SeatPO> listPage(SeatQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SeatPO> listAll(SeatQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SeatPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
