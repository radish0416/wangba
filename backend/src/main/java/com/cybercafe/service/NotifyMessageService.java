/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.NotifyMessagePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.NotifyMessageQueryDTO;

/** 站内消息 服务。 */
public interface NotifyMessageService {
    /** 分页查询 */ IPage<NotifyMessagePO> listPage(NotifyMessageQueryDTO dto);
    /** 全量查询 */ java.util.List<NotifyMessagePO> listAll(NotifyMessageQueryDTO dto);
    /** 详情 */ NotifyMessagePO detail(Long id);
    /** 新增 */ Boolean create(NotifyMessagePO po);
    /** 修改 */ Boolean update(NotifyMessagePO po);
    /** 删除 */ Boolean delete(Long id);
}
