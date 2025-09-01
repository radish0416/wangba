/**
 * 本文件由工具自动生成，请勿手工修改。
 * 生成器: tools/codegen/generate_from_sql.py
 */
package com.cybercafe.web.controller;
import com.cybercafe.service.GoodsCategoryService;
import com.cybercafe.domain.po.GoodsCategoryPO;
import com.cybercafe.web.dto.GoodsCategoryQueryDTO;
import com.cybercafe.common.ApiResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 商品类目 控制器。 */
@RestController
@RequestMapping("/api/goods_category")
@Tag(name = "商品类目")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService service;

@PostMapping("/listPage")
@Operation(summary = "分页查询")
    public ApiResponse<IPage<GoodsCategoryPO>> listPage(@RequestBody @Validated GoodsCategoryQueryDTO dto) {
        return ApiResponse.ok(service.listPage(dto));
    }

@PostMapping("/listAll")
@Operation(summary = "全量查询")
    public ApiResponse<java.util.List<GoodsCategoryPO>> listAll(@RequestBody @Validated GoodsCategoryQueryDTO dto) {
        return ApiResponse.ok(service.listAll(dto));
    }

@PostMapping("/detail")
@Operation(summary = "详情")
    public ApiResponse<GoodsCategoryPO> detail(@RequestBody java.util.Map<String, Long> req) {
        return ApiResponse.ok(service.detail(req.get("id")));
    }
}
