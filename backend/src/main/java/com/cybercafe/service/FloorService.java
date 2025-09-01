/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.FloorPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.FloorQueryDTO;

/** 楼层 服务。 */
public interface FloorService {
    /** 分页查询 */ IPage<FloorPO> listPage(FloorQueryDTO dto);
    /** 全量查询 */ java.util.List<FloorPO> listAll(FloorQueryDTO dto);
    /** 详情 */ FloorPO detail(Long id);
    /** 新增 */ Boolean create(FloorPO po);
    /** 修改 */ Boolean update(FloorPO po);
    /** 删除 */ Boolean delete(Long id);
}
