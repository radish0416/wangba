/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.GoodsCategoryPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.GoodsCategoryQueryDTO;

/** 商品类目 服务。 */
public interface GoodsCategoryService {
    /** 分页查询 */ IPage<GoodsCategoryPO> listPage(GoodsCategoryQueryDTO dto);
    /** 全量查询 */ java.util.List<GoodsCategoryPO> listAll(GoodsCategoryQueryDTO dto);
    /** 详情 */ GoodsCategoryPO detail(Long id);
    /** 新增 */ Boolean create(GoodsCategoryPO po);
    /** 修改 */ Boolean update(GoodsCategoryPO po);
    /** 删除 */ Boolean delete(Long id);
}
