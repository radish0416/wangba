/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.OrderPaymentPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.OrderPaymentQueryDTO;

/** 订单支付记录 Mapper。 */
public interface OrderPaymentMapper extends BaseMapper<OrderPaymentPO> {
    IPage<OrderPaymentPO> selectByDynamic(Page<?> page, @Param("dto") OrderPaymentQueryDTO dto);
    OrderPaymentPO selectDetail(@Param("id") Long id);
}
