/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.DictItemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DictItemQueryDTO;

/** 字典项 服务。 */
public interface DictItemService {
    /** 分页查询 */ IPage<DictItemPO> listPage(DictItemQueryDTO dto);
    /** 全量查询 */ java.util.List<DictItemPO> listAll(DictItemQueryDTO dto);
    /** 详情 */ DictItemPO detail(Long id);
    /** 新增 */ Boolean create(DictItemPO po);
    /** 修改 */ Boolean update(DictItemPO po);
    /** 删除 */ Boolean delete(Long id);
}
