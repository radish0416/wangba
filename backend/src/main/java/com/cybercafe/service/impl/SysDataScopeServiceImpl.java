/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysDataScopeService;
import com.cybercafe.repository.mapper.SysDataScopeMapper;
import com.cybercafe.domain.po.SysDataScopePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysDataScopeQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 数据范围定义 服务实现。 */
@Service
public class SysDataScopeServiceImpl implements SysDataScopeService {
    @Autowired
    private SysDataScopeMapper mapper;

    @Override
    public IPage<SysDataScopePO> listPage(SysDataScopeQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysDataScopePO> listAll(SysDataScopeQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysDataScopePO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
