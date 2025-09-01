/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.PackageBenefitService;
import com.cybercafe.domain.po.PackageBenefitPO;
import com.cybercafe.web.dto.PackageBenefitQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 套餐权益 控制器。 */
@RestController
@RequestMapping("/api/package_benefit")
@Tag(name = "套餐权益")
public class PackageBenefitController {
    @Autowired
    private PackageBenefitService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<PackageBenefitPO>> listPage(@RequestBody @Validated PackageBenefitQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<PackageBenefitPO>> listAll(@RequestBody @Validated PackageBenefitQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<PackageBenefitPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }
}
