/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.MemberUserService;
import com.cybercafe.repository.mapper.MemberUserMapper;
import com.cybercafe.domain.po.MemberUserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.MemberUserQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 用户会员记录 服务实现。 */
@Service
public class MemberUserServiceImpl implements MemberUserService {
    private static final Logger log = LoggerFactory.getLogger(MemberUserServiceImpl.class);
    @Resource
    private MemberUserMapper mapper;

    @Override
    public IPage<MemberUserPO> listPage(MemberUserQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<MemberUserPO> listAll(MemberUserQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public MemberUserPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(MemberUserPO po) {
        log.info("create member_user id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(MemberUserPO po) {
        log.info("update member_user id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete member_user id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
