/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.PackageDefService;
import com.cybercafe.repository.mapper.PackageDefMapper;
import com.cybercafe.domain.po.PackageDefPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.PackageDefQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 套餐定义 服务实现。 */
@Service
public class PackageDefServiceImpl implements PackageDefService {
    private static final Logger log = LoggerFactory.getLogger(PackageDefServiceImpl.class);
    @Resource
    private PackageDefMapper mapper;

    @Override
    public IPage<PackageDefPO> listPage(PackageDefQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<PackageDefPO> listAll(PackageDefQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public PackageDefPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(PackageDefPO po) {
        log.info("create package_def id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(PackageDefPO po) {
        log.info("update package_def id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete package_def id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
