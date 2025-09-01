/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.OrderMasterPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderMasterQueryDTO;

/** 订单主表 服务。 */
public interface OrderMasterService {
    /** 分页查询 */ IPage<OrderMasterPO> listPage(OrderMasterQueryDTO dto);
    /** 全量查询 */ java.util.List<OrderMasterPO> listAll(OrderMasterQueryDTO dto);
    /** 详情 */ OrderMasterPO detail(Long id);
    /** 新增 */ Boolean create(OrderMasterPO po);
    /** 修改 */ Boolean update(OrderMasterPO po);
    /** 删除 */ Boolean delete(Long id);
}
