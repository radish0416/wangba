/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.service;
import com.cybercafe.domain.po.UserPackagePO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cybercafe.web.dto.UserPackageQueryDTO;

/** 用户持有套餐 服务。 */
public interface UserPackageService {
    /** 分页查询 */ IPage<UserPackagePO> listPage(UserPackageQueryDTO dto);
    /** 全量查询 */ java.util.List<UserPackagePO> listAll(UserPackageQueryDTO dto);
    /** 详情 */ UserPackagePO detail(Long id);
    /** 新增 */ Boolean create(UserPackagePO po);
    /** 修改 */ Boolean update(UserPackagePO po);
    /** 删除 */ Boolean delete(Long id);
}
