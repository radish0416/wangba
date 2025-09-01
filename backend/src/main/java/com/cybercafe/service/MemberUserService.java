/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.MemberUserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.MemberUserQueryDTO;

/** 用户会员记录 服务。 */
public interface MemberUserService {
    /** 分页查询 */ IPage<MemberUserPO> listPage(MemberUserQueryDTO dto);
    /** 全量查询 */ java.util.List<MemberUserPO> listAll(MemberUserQueryDTO dto);
    /** 详情 */ MemberUserPO detail(Long id);
    /** 新增 */ Boolean create(MemberUserPO po);
    /** 修改 */ Boolean update(MemberUserPO po);
    /** 删除 */ Boolean delete(Long id);
}
