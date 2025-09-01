/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PointsLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PointsLedgerQueryDTO;

/** 积分流水 服务。 */
public interface PointsLedgerService {
    IPage<PointsLedgerPO> listPage(PointsLedgerQueryDTO dto);
    java.util.List<PointsLedgerPO> listAll(PointsLedgerQueryDTO dto);
    PointsLedgerPO detail(Long id);
}
