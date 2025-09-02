/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.GoodsSkuService;
import com.cybercafe.repository.mapper.GoodsSkuMapper;
import com.cybercafe.domain.po.GoodsSkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsSkuQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 商品SKU 服务实现。 */
@Service
public class GoodsSkuServiceImpl implements GoodsSkuService {
    private static final Logger log = LoggerFactory.getLogger(GoodsSkuServiceImpl.class);
    @Resource
    private GoodsSkuMapper mapper;

    @Override
    public IPage<GoodsSkuPO> listPage(GoodsSkuQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<GoodsSkuPO> listAll(GoodsSkuQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public GoodsSkuPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(GoodsSkuPO po) {
        log.info("create goods_sku id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(GoodsSkuPO po) {
        log.info("update goods_sku id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete goods_sku id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
