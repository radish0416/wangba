/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PayTransactionPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PayTransactionQueryDTO;

/** 支付交易 服务。 */
public interface PayTransactionService {
    /** 分页查询 */ IPage<PayTransactionPO> listPage(PayTransactionQueryDTO dto);
    /** 全量查询 */ java.util.List<PayTransactionPO> listAll(PayTransactionQueryDTO dto);
    /** 详情 */ PayTransactionPO detail(Long id);
    /** 新增 */ Boolean create(PayTransactionPO po);
    /** 修改 */ Boolean update(PayTransactionPO po);
    /** 删除 */ Boolean delete(Long id);
}
