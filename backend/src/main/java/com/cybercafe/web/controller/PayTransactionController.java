/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.PayTransactionService;
import com.cybercafe.domain.po.PayTransactionPO;
import com.cybercafe.web.dto.PayTransactionQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

/** 支付交易 控制器。 */
@RestController
@RequestMapping("/api/pay_transaction")
@Tag(name = "支付交易")
public class PayTransactionController {
    @Resource
    private PayTransactionService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<PayTransactionPO>> listPage(@RequestBody @Validated PayTransactionQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<PayTransactionPO>> listAll(@RequestBody @Validated PayTransactionQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<PayTransactionPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }

@PostMapping("/create")
@Operation(summary = "新增")
    public ApiResponse<Boolean> create(@RequestBody @Validated PayTransactionPO po) {
        return ApiResponse.ok(service.create(po));
    }

@PostMapping("/update")
@Operation(summary = "修改")
    public ApiResponse<Boolean> update(@RequestBody @Validated PayTransactionPO po) {
        return ApiResponse.ok(service.update(po));
    }

@PostMapping("/delete")
@Operation(summary = "删除")
    public ApiResponse<Boolean> delete(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.delete(req.get("id")));
    }
}
