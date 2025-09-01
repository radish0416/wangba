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
    IPage<MemberUserPO> listPage(MemberUserQueryDTO dto);
    java.util.List<MemberUserPO> listAll(MemberUserQueryDTO dto);
    MemberUserPO detail(Long id);
}
