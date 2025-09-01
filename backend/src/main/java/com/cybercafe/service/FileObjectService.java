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
    IPage<FileObjectPO> listPage(FileObjectQueryDTO dto);
    java.util.List<FileObjectPO> listAll(FileObjectQueryDTO dto);
    FileObjectPO detail(Long id);
}
