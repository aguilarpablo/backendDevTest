package com.backend.dev.test.domain.repository;

import com.backend.dev.test.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(String id);

    List<String> findIdsOfSimilarProductsById(String id);
}
