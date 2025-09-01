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
import org.springframework.beans.factory.annotation.Autowired;

/** 权限点 服务实现。 */
@Service
public class SysPermServiceImpl implements SysPermService {
    @Autowired
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
}
