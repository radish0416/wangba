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
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 商品类目 服务实现。 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    private static final Logger log = LoggerFactory.getLogger(GoodsCategoryServiceImpl.class);
    @Resource
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

    @Override
    public Boolean create(GoodsCategoryPO po) {
        log.info("create goods_category id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(GoodsCategoryPO po) {
        log.info("update goods_category id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete goods_category id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
