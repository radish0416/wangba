/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.UserPackageService;
import com.cybercafe.repository.mapper.UserPackageMapper;
import com.cybercafe.domain.po.UserPackagePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.UserPackageQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 用户持有套餐 服务实现。 */
@Service
public class UserPackageServiceImpl implements UserPackageService {
    private static final Logger log = LoggerFactory.getLogger(UserPackageServiceImpl.class);
    @Resource
    private UserPackageMapper mapper;

    @Override
    public IPage<UserPackagePO> listPage(UserPackageQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<UserPackagePO> listAll(UserPackageQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public UserPackagePO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(UserPackagePO po) {
        log.info("create user_package id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(UserPackagePO po) {
        log.info("update user_package id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete user_package id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
