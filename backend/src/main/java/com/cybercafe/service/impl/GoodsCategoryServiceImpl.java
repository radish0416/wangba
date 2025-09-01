/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.GoodsCategoryService;
import com.cybercafe.repository.mapper.GoodsCategoryMapper;
import com.cybercafe.domain.po.GoodsCategoryPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsCategoryQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 商品类目 服务实现。 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper mapper;

    @Override
    public IPage<GoodsCategoryPO> listPage(GoodsCategoryQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<GoodsCategoryPO> listAll(GoodsCategoryQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public GoodsCategoryPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
