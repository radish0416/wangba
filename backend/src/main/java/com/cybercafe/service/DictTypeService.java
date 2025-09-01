/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.DictTypePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DictTypeQueryDTO;

/** 字典类型 服务。 */
public interface DictTypeService {
    /** 分页查询 */ IPage<DictTypePO> listPage(DictTypeQueryDTO dto);
    /** 全量查询 */ java.util.List<DictTypePO> listAll(DictTypeQueryDTO dto);
    /** 详情 */ DictTypePO detail(Long id);
    /** 新增 */ Boolean create(DictTypePO po);
    /** 修改 */ Boolean update(DictTypePO po);
    /** 删除 */ Boolean delete(Long id);
}
