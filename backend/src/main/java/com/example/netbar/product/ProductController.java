package com.example.netbar.product;

import com.example.netbar.common.api.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final JpaRepository<Product, Long> repo;

    public ProductController(JpaRepository<Product, Long> repo) {
        this.repo = repo;
    }

    @PostMapping
    public ApiResponse<Product> create(@RequestBody @Valid Product product) {
        product.setEnabled(true);
        return ApiResponse.success(repo.save(product));
    }

    @GetMapping("/list")
    public ApiResponse<List<Product>> list(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        Page<Product> p = repo.findAll(PageRequest.of(page, size));
        return ApiResponse.success(p.getContent());
    }
}

