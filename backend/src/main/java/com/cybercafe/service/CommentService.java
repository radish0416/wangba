/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.CommentPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.CommentQueryDTO;

/** 评论 服务。 */
public interface CommentService {
    /** 分页查询 */ IPage<CommentPO> listPage(CommentQueryDTO dto);
    /** 全量查询 */ java.util.List<CommentPO> listAll(CommentQueryDTO dto);
    /** 详情 */ CommentPO detail(Long id);
    /** 新增 */ Boolean create(CommentPO po);
    /** 修改 */ Boolean update(CommentPO po);
    /** 删除 */ Boolean delete(Long id);
}
