/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.DictItemService;
import com.cybercafe.repository.mapper.DictItemMapper;
import com.cybercafe.domain.po.DictItemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DictItemQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 字典项 服务实现。 */
@Service
public class DictItemServiceImpl implements DictItemService {
    @Autowired
    private DictItemMapper mapper;

    @Override
    public IPage<DictItemPO> listPage(DictItemQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<DictItemPO> listAll(DictItemQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public DictItemPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
