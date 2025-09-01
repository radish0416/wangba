/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PointsAccountPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PointsAccountQueryDTO;

/** 积分账户 服务。 */
public interface PointsAccountService {
    /** 分页查询 */ IPage<PointsAccountPO> listPage(PointsAccountQueryDTO dto);
    /** 全量查询 */ java.util.List<PointsAccountPO> listAll(PointsAccountQueryDTO dto);
    /** 详情 */ PointsAccountPO detail(Long id);
    /** 新增 */ Boolean create(PointsAccountPO po);
    /** 修改 */ Boolean update(PointsAccountPO po);
    /** 删除 */ Boolean delete(Long id);
}
