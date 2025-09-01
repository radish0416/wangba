/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.PostPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PostQueryDTO;

/** 帖子 服务。 */
public interface PostService {
    IPage<PostPO> listPage(PostQueryDTO dto);
    java.util.List<PostPO> listAll(PostQueryDTO dto);
    PostPO detail(Long id);
}
