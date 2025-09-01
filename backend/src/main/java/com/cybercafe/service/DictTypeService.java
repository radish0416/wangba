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
    IPage<DictTypePO> listPage(DictTypeQueryDTO dto);
    java.util.List<DictTypePO> listAll(DictTypeQueryDTO dto);
    DictTypePO detail(Long id);
}
