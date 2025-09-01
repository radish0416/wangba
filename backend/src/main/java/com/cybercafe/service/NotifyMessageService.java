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
    IPage<NotifyMessagePO> listPage(NotifyMessageQueryDTO dto);
    java.util.List<NotifyMessagePO> listAll(NotifyMessageQueryDTO dto);
    NotifyMessagePO detail(Long id);
}
