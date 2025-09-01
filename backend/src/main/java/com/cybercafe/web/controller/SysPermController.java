/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.SysPermService;
import com.cybercafe.domain.po.SysPermPO;
import com.cybercafe.web.dto.SysPermQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

/** 权限点 控制器。 */
@RestController
@RequestMapping("/api/sys_perm")
@Tag(name = "权限点")
public class SysPermController {
    @Resource
    private SysPermService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<SysPermPO>> listPage(@RequestBody @Validated SysPermQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<SysPermPO>> listAll(@RequestBody @Validated SysPermQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<SysPermPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }

@PostMapping("/create")
@Operation(summary = "新增")
    public ApiResponse<Boolean> create(@RequestBody @Validated SysPermPO po) {
        return ApiResponse.ok(service.create(po));
    }

@PostMapping("/update")
@Operation(summary = "修改")
    public ApiResponse<Boolean> update(@RequestBody @Validated SysPermPO po) {
        return ApiResponse.ok(service.update(po));
    }

@PostMapping("/delete")
@Operation(summary = "删除")
    public ApiResponse<Boolean> delete(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.delete(req.get("id")));
    }
}
