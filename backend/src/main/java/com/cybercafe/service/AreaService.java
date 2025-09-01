/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.AreaPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.AreaQueryDTO;

/** 区域 服务。 */
public interface AreaService {
    IPage<AreaPO> listPage(AreaQueryDTO dto);
    java.util.List<AreaPO> listAll(AreaQueryDTO dto);
    AreaPO detail(Long id);
}
