/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.GoodsPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsQueryDTO;

/** 商品 服务。 */
public interface GoodsService {
    IPage<GoodsPO> listPage(GoodsQueryDTO dto);
    java.util.List<GoodsPO> listAll(GoodsQueryDTO dto);
    GoodsPO detail(Long id);
}
