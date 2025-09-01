/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.SeatSessionPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SeatSessionQueryDTO;

/** 机位会话 服务。 */
public interface SeatSessionService {
    /** 分页查询 */ IPage<SeatSessionPO> listPage(SeatSessionQueryDTO dto);
    /** 全量查询 */ java.util.List<SeatSessionPO> listAll(SeatSessionQueryDTO dto);
    /** 详情 */ SeatSessionPO detail(Long id);
    /** 新增 */ Boolean create(SeatSessionPO po);
    /** 修改 */ Boolean update(SeatSessionPO po);
    /** 删除 */ Boolean delete(Long id);
}
