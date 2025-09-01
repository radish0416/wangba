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
    /** 分页查询 */ IPage<OrderItemPO> listPage(OrderItemQueryDTO dto);
    /** 全量查询 */ java.util.List<OrderItemPO> listAll(OrderItemQueryDTO dto);
    /** 详情 */ OrderItemPO detail(Long id);
    /** 新增 */ Boolean create(OrderItemPO po);
    /** 修改 */ Boolean update(OrderItemPO po);
    /** 删除 */ Boolean delete(Long id);
}
