/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SysRolePermService;
import com.cybercafe.repository.mapper.SysRolePermMapper;
import com.cybercafe.domain.po.SysRolePermPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SysRolePermQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 角色-权限 服务实现。 */
@Service
public class SysRolePermServiceImpl implements SysRolePermService {
    private static final Logger log = LoggerFactory.getLogger(SysRolePermServiceImpl.class);
    @Resource
    private SysRolePermMapper mapper;

    @Override
    public IPage<SysRolePermPO> listPage(SysRolePermQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SysRolePermPO> listAll(SysRolePermQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SysRolePermPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SysRolePermPO po) {
        log.info("create sys_role_perm id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SysRolePermPO po) {
        log.info("update sys_role_perm id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete sys_role_perm id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
