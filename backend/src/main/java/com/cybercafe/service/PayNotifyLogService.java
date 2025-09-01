/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PayNotifyLogPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PayNotifyLogQueryDTO;

/** 支付回调日志 服务。 */
public interface PayNotifyLogService {
    IPage<PayNotifyLogPO> listPage(PayNotifyLogQueryDTO dto);
    java.util.List<PayNotifyLogPO> listAll(PayNotifyLogQueryDTO dto);
    PayNotifyLogPO detail(Long id);
}
