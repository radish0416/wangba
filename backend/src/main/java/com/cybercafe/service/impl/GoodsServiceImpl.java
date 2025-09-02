/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.GoodsService;
import com.cybercafe.repository.mapper.GoodsMapper;
import com.cybercafe.domain.po.GoodsPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 商品 服务实现。 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Resource
    private GoodsMapper mapper;

    @Override
    public IPage<GoodsPO> listPage(GoodsQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<GoodsPO> listAll(GoodsQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public GoodsPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(GoodsPO po) {
        log.info("create goods id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(GoodsPO po) {
        log.info("update goods id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete goods id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
