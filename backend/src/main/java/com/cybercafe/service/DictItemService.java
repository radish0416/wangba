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
    IPage<DictItemPO> listPage(DictItemQueryDTO dto);
    java.util.List<DictItemPO> listAll(DictItemQueryDTO dto);
    DictItemPO detail(Long id);
}
