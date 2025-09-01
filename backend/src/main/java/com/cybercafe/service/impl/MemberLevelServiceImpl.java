/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.MemberLevelService;
import com.cybercafe.repository.mapper.MemberLevelMapper;
import com.cybercafe.domain.po.MemberLevelPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.MemberLevelQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 会员等级 服务实现。 */
@Service
public class MemberLevelServiceImpl implements MemberLevelService {
    private static final Logger log = LoggerFactory.getLogger(MemberLevelServiceImpl.class);
    @Resource
    private MemberLevelMapper mapper;

    @Override
    public IPage<MemberLevelPO> listPage(MemberLevelQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<MemberLevelPO> listAll(MemberLevelQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public MemberLevelPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(MemberLevelPO po) {
        log.info("create member_level id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(MemberLevelPO po) {
        log.info("update member_level id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete member_level id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
