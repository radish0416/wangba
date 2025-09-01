/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.SeatService;
import com.cybercafe.domain.po.SeatPO;
import com.cybercafe.web.dto.SeatQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 机位 控制器。 */
@RestController
@RequestMapping("/api/seat")
@Tag(name = "机位")
public class SeatController {
    @Autowired
    private SeatService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<SeatPO>> listPage(@RequestBody @Validated SeatQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<SeatPO>> listAll(@RequestBody @Validated SeatQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<SeatPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }
}
