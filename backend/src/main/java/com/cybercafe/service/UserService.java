/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.UserPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.UserQueryDTO;

/** 用户 服务。 */
public interface UserService {
    IPage<UserPO> listPage(UserQueryDTO dto);
    java.util.List<UserPO> listAll(UserQueryDTO dto);
    UserPO detail(Long id);
}
