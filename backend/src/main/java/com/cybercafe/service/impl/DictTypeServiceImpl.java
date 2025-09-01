/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.DictTypeService;
import com.cybercafe.repository.mapper.DictTypeMapper;
import com.cybercafe.domain.po.DictTypePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DictTypeQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 字典类型 服务实现。 */
@Service
public class DictTypeServiceImpl implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    public IPage<DictTypePO> listPage(DictTypeQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<DictTypePO> listAll(DictTypeQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public DictTypePO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
