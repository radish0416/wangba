/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.OrderRefundPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderRefundQueryDTO;

/** 订单退款 服务。 */
public interface OrderRefundService {
    /** 分页查询 */ IPage<OrderRefundPO> listPage(OrderRefundQueryDTO dto);
    /** 全量查询 */ java.util.List<OrderRefundPO> listAll(OrderRefundQueryDTO dto);
    /** 详情 */ OrderRefundPO detail(Long id);
    /** 新增 */ Boolean create(OrderRefundPO po);
    /** 修改 */ Boolean update(OrderRefundPO po);
    /** 删除 */ Boolean delete(Long id);
}
