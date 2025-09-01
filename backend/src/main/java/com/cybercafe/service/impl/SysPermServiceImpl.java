/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysPermService;
import com.cybercafe.repository.mapper.SysPermMapper;
import com.cybercafe.domain.po.SysPermPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysPermQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 权限点 服务实现。 */
@Service
public class SysPermServiceImpl implements SysPermService {
    private static final Logger log = LoggerFactory.getLogger(SysPermServiceImpl.class);
    @Resource
    private SysPermMapper mapper;

    @Override
    public IPage<SysPermPO> listPage(SysPermQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysPermPO> listAll(SysPermQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysPermPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysPermPO po) {
        log.info("create sys_perm id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysPermPO po) {
        log.info("update sys_perm id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_perm id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
