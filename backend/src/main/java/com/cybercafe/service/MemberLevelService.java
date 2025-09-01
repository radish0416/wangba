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
    IPage<MemberLevelPO> listPage(MemberLevelQueryDTO dto);
    java.util.List<MemberLevelPO> listAll(MemberLevelQueryDTO dto);
    MemberLevelPO detail(Long id);
}
