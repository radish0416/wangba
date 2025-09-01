/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.FileObjectPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.FileObjectQueryDTO;

/** 文件对象 服务。 */
public interface FileObjectService {
    /** 分页查询 */ IPage<FileObjectPO> listPage(FileObjectQueryDTO dto);
    /** 全量查询 */ java.util.List<FileObjectPO> listAll(FileObjectQueryDTO dto);
    /** 详情 */ FileObjectPO detail(Long id);
    /** 新增 */ Boolean create(FileObjectPO po);
    /** 修改 */ Boolean update(FileObjectPO po);
    /** 删除 */ Boolean delete(Long id);
}
