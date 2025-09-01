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
    /** 分页查询 */ IPage<GoodsPO> listPage(GoodsQueryDTO dto);
    /** 全量查询 */ java.util.List<GoodsPO> listAll(GoodsQueryDTO dto);
    /** 详情 */ GoodsPO detail(Long id);
    /** 新增 */ Boolean create(GoodsPO po);
    /** 修改 */ Boolean update(GoodsPO po);
    /** 删除 */ Boolean delete(Long id);
}
