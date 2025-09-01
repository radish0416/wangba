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
    /** 分页查询 */ IPage<UserPO> listPage(UserQueryDTO dto);
    /** 全量查询 */ java.util.List<UserPO> listAll(UserQueryDTO dto);
    /** 详情 */ UserPO detail(Long id);
    /** 新增 */ Boolean create(UserPO po);
    /** 修改 */ Boolean update(UserPO po);
    /** 删除 */ Boolean delete(Long id);
}
