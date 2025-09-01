/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.ConsumeRecordPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.ConsumeRecordQueryDTO;

/** 消费记录 服务。 */
public interface ConsumeRecordService {
    /** 分页查询 */ IPage<ConsumeRecordPO> listPage(ConsumeRecordQueryDTO dto);
    /** 全量查询 */ java.util.List<ConsumeRecordPO> listAll(ConsumeRecordQueryDTO dto);
    /** 详情 */ ConsumeRecordPO detail(Long id);
    /** 新增 */ Boolean create(ConsumeRecordPO po);
    /** 修改 */ Boolean update(ConsumeRecordPO po);
    /** 删除 */ Boolean delete(Long id);
}
