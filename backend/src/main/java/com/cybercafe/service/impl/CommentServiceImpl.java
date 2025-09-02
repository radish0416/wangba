/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.CommentService;
import com.cybercafe.repository.mapper.CommentMapper;
import com.cybercafe.domain.po.CommentPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.CommentQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 评论 服务实现。 */
@Service
public class CommentServiceImpl implements CommentService {
    private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Resource
    private CommentMapper mapper;

    @Override
    public IPage<CommentPO> listPage(CommentQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<CommentPO> listAll(CommentQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public CommentPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(CommentPO po) {
        log.info("create comment id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(CommentPO po) {
        log.info("update comment id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete comment id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
