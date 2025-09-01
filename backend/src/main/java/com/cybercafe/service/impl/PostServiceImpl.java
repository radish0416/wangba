/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PostService;
import com.cybercafe.repository.mapper.PostMapper;
import com.cybercafe.domain.po.PostPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PostQueryDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/** 帖子 服务实现。 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper mapper;

    @Override
    public IPage<PostPO> listPage(PostQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PostPO> listAll(PostQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PostPO detail(Long id) {
        return mapper.selectDetail(id);
    }
}
