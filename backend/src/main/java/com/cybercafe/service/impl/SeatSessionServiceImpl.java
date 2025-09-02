/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service.impl;
import com.cybercafe.service.SeatSessionService;
import com.cybercafe.repository.mapper.SeatSessionMapper;
import com.cybercafe.domain.po.SeatSessionPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.SeatSessionQueryDTO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 机位会话 服务实现。 */
@Service
public class SeatSessionServiceImpl implements SeatSessionService {
    private static final Logger log = LoggerFactory.getLogger(SeatSessionServiceImpl.class);
    @Resource
    private SeatSessionMapper mapper;

    @Override
    public IPage<SeatSessionPO> listPage(SeatSessionQueryDTO dto) {
        Page<?> page = new Page<>(dto.current == null ? 1 : dto.current, dto.size == null ? 10 : dto.size);
        return mapper.selectByDynamic(page, dto);
    }

    @Override
    public java.util.List<SeatSessionPO> listAll(SeatSessionQueryDTO dto) {
        return mapper.selectByDynamic(new Page<>(1, Integer.MAX_VALUE), dto).getRecords();
    }

    @Override
    public SeatSessionPO detail(Long id) {
        return mapper.selectDetail(id);
    }

    @Override
    public Boolean create(SeatSessionPO po) {
        log.info("create seat_session id={}", po.getId());
        return mapper.insert(po) > 0;
    }

    @Override
    public Boolean update(SeatSessionPO po) {
        log.info("update seat_session id={}", po.getId());
        return mapper.updateById(po) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        log.warn("delete seat_session id={}", id);
        return mapper.deleteById(id) > 0;
    }
}
