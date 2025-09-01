/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.PointsLedgerService;
import com.cybercafe.domain.po.PointsLedgerPO;
import com.cybercafe.web.dto.PointsLedgerQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

/** 积分流水 控制器。 */
@RestController
@RequestMapping("/api/points_ledger")
@Tag(name = "积分流水")
public class PointsLedgerController {
    @Resource
    private PointsLedgerService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<PointsLedgerPO>> listPage(@RequestBody @Validated PointsLedgerQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<PointsLedgerPO>> listAll(@RequestBody @Validated PointsLedgerQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<PointsLedgerPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }

@PostMapping("/create")
@Operation(summary = "新增")
    public ApiResponse<Boolean> create(@RequestBody @Validated PointsLedgerPO po) {
        return ApiResponse.ok(service.create(po));
    }

@PostMapping("/update")
@Operation(summary = "修改")
    public ApiResponse<Boolean> update(@RequestBody @Validated PointsLedgerPO po) {
        return ApiResponse.ok(service.update(po));
    }

@PostMapping("/delete")
@Operation(summary = "删除")
    public ApiResponse<Boolean> delete(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.delete(req.get("id")));
    }
}
