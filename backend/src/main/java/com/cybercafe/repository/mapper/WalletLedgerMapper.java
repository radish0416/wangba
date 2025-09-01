/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.repository.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cybercafe.domain.po.WalletLedgerPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.cybercafe.web.dto.WalletLedgerQueryDTO;

/** 钱包流水 Mapper。 */
public interface WalletLedgerMapper extends BaseMapper<WalletLedgerPO> {
    IPage<WalletLedgerPO> selectByDynamic(Page<?> page, @Param("dto") WalletLedgerQueryDTO dto);
    WalletLedgerPO selectDetail(@Param("id") Long id);
}
