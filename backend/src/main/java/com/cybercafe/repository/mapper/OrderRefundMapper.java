/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.OrderRefundPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.OrderRefundQueryDTO;

/** 订单退款 Mapper。 */
public interface OrderRefundMapper extends BaseMapper<OrderRefundPO> {
    IPage<OrderRefundPO> selectByDynamic(Page<?> page, @Param("dto") OrderRefundQueryDTO dto);
    OrderRefundPO selectDetail(@Param("id") Long id);
}
