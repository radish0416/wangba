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
    /** 分页查询 */ IPage<PayNotifyLogPO> listPage(PayNotifyLogQueryDTO dto);
    /** 全量查询 */ java.util.List<PayNotifyLogPO> listAll(PayNotifyLogQueryDTO dto);
    /** 详情 */ PayNotifyLogPO detail(Long id);
    /** 新增 */ Boolean create(PayNotifyLogPO po);
    /** 修改 */ Boolean update(PayNotifyLogPO po);
    /** 删除 */ Boolean delete(Long id);
}
