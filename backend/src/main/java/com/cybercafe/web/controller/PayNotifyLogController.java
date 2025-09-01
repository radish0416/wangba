/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.PayNotifyLogService;
import com.cybercafe.domain.po.PayNotifyLogPO;
import com.cybercafe.web.dto.PayNotifyLogQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 支付回调日志 控制器。 */
@RestController
@RequestMapping("/api/pay_notify_log")
@Tag(name = "支付回调日志")
public class PayNotifyLogController {
    @Autowired
    private PayNotifyLogService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<PayNotifyLogPO>> listPage(@RequestBody @Validated PayNotifyLogQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<PayNotifyLogPO>> listAll(@RequestBody @Validated PayNotifyLogQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<PayNotifyLogPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }
}
