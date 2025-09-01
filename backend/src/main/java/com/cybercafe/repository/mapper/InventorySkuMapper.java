/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.InventorySkuPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.InventorySkuQueryDTO;

/** 库存SKU Mapper。 */
public interface InventorySkuMapper extends BaseMapper<InventorySkuPO> {
    IPage<InventorySkuPO> selectByDynamic(Page<?> page, @Param("dto") InventorySkuQueryDTO dto);
    InventorySkuPO selectDetail(@Param("id") Long id);
}
