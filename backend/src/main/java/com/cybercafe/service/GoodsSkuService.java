/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.GoodsSkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsSkuQueryDTO;

/** 商品SKU 服务。 */
public interface GoodsSkuService {
    IPage<GoodsSkuPO> listPage(GoodsSkuQueryDTO dto);
    java.util.List<GoodsSkuPO> listAll(GoodsSkuQueryDTO dto);
    GoodsSkuPO detail(Long id);
}
