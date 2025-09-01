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
    IPage<OrderMasterPO> listPage(OrderMasterQueryDTO dto);
    java.util.List<OrderMasterPO> listAll(OrderMasterQueryDTO dto);
    OrderMasterPO detail(Long id);
}
