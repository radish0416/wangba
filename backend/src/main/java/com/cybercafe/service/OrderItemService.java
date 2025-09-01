/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.OrderItemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderItemQueryDTO;

/** 订单明细 服务。 */
public interface OrderItemService {
    IPage<OrderItemPO> listPage(OrderItemQueryDTO dto);
    java.util.List<OrderItemPO> listAll(OrderItemQueryDTO dto);
    OrderItemPO detail(Long id);
}
