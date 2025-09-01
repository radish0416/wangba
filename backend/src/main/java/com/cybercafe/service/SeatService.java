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
    IPage<SeatPO> listPage(SeatQueryDTO dto);
    java.util.List<SeatPO> listAll(SeatQueryDTO dto);
    SeatPO detail(Long id);
}
