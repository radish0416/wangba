/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.OrderPaymentPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.OrderPaymentQueryDTO;

/** 订单支付记录 服务。 */
public interface OrderPaymentService {
    /** 分页查询 */ IPage<OrderPaymentPO> listPage(OrderPaymentQueryDTO dto);
    /** 全量查询 */ java.util.List<OrderPaymentPO> listAll(OrderPaymentQueryDTO dto);
    /** 详情 */ OrderPaymentPO detail(Long id);
    /** 新增 */ Boolean create(OrderPaymentPO po);
    /** 修改 */ Boolean update(OrderPaymentPO po);
    /** 删除 */ Boolean delete(Long id);
}
