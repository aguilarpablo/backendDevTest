package com.backend.dev.test.infrastructure.controller;

import com.backend.dev.test.application.ProductApplicationService;
import com.backend.dev.test.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductApplicationService productApplicationService;

    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<List<Product>> similarProducts(@PathVariable String productId) {
        return ResponseEntity.ok(productApplicationService.getSimilarProductsByProductId(productId));
    }
}
