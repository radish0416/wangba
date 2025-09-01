/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.DictItemService;
import com.cybercafe.repository.mapper.DictItemMapper;
import com.cybercafe.domain.po.DictItemPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.DictItemQueryDTO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 字典项 服务实现。 */
@Service
public class DictItemServiceImpl implements DictItemService {
    private static final Logger log = LoggerFactory.getLogger(DictItemServiceImpl.class);
    @Resource
    private DictItemMapper mapper;

    @Override
    public IPage<DictItemPO> listPage(DictItemQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<DictItemPO> listAll(DictItemQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public DictItemPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(DictItemPO po) {
        log.info("create dict_item id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(DictItemPO po) {
        log.info("update dict_item id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete dict_item id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
