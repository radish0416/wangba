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
    IPage<PayTransactionPO> listPage(PayTransactionQueryDTO dto);
    java.util.List<PayTransactionPO> listAll(PayTransactionQueryDTO dto);
    PayTransactionPO detail(Long id);
}
