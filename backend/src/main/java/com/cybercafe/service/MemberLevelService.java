/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.MemberLevelPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.MemberLevelQueryDTO;

/** 会员等级 服务。 */
public interface MemberLevelService {
    /** 分页查询 */ IPage<MemberLevelPO> listPage(MemberLevelQueryDTO dto);
    /** 全量查询 */ java.util.List<MemberLevelPO> listAll(MemberLevelQueryDTO dto);
    /** 详情 */ MemberLevelPO detail(Long id);
    /** 新增 */ Boolean create(MemberLevelPO po);
    /** 修改 */ Boolean update(MemberLevelPO po);
    /** 删除 */ Boolean delete(Long id);
}
