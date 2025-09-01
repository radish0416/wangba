/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SeatPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SeatQueryDTO;

/** 机位 服务。 */
public interface SeatService {
    /** 分页查询 */ IPage<SeatPO> listPage(SeatQueryDTO dto);
    /** 全量查询 */ java.util.List<SeatPO> listAll(SeatQueryDTO dto);
    /** 详情 */ SeatPO detail(Long id);
    /** 新增 */ Boolean create(SeatPO po);
    /** 修改 */ Boolean update(SeatPO po);
    /** 删除 */ Boolean delete(Long id);
}
