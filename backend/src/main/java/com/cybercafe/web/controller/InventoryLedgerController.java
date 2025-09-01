/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.InventoryLedgerService;
import com.cybercafe.domain.po.InventoryLedgerPO;
import com.cybercafe.web.dto.InventoryLedgerQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 库存流水 控制器。 */
@RestController
@RequestMapping("/api/inventory_ledger")
@Tag(name = "库存流水")
public class InventoryLedgerController {
    @Autowired
    private InventoryLedgerService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<InventoryLedgerPO>> listPage(@RequestBody @Validated InventoryLedgerQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<InventoryLedgerPO>> listAll(@RequestBody @Validated InventoryLedgerQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<InventoryLedgerPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }
}
