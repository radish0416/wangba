/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysUserService;
import com.cybercafe.repository.mapper.SysUserMapper;
import com.cybercafe.domain.po.SysUserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysUserQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 后台账户 服务实现。 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Resource
    private SysUserMapper mapper;

    @Override
    public IPage<SysUserPO> listPage(SysUserQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysUserPO> listAll(SysUserQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysUserPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysUserPO po) {
        log.info("create sys_user id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysUserPO po) {
        log.info("update sys_user id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_user id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
