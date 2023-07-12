package com.backend.dev.test.infrastructure.repository;

import com.backend.dev.test.domain.model.Product;
import com.backend.dev.test.domain.repository.ProductRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductRepositoryConfig productRepositoryConfig;
    private final RestTemplate restTemplate;

    public ProductRepositoryImpl(ProductRepositoryConfig productRepositoryConfig, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        this.productRepositoryConfig = productRepositoryConfig;
    }


    @Override
    public Product findById(String id) {
        ResponseEntity<Product> response = restTemplate.getForEntity(
                productRepositoryConfig.getBaseUrl() + "/product/" + id,
                Product.class
        );
        return response.getBody();
    }

    @Override
    public List<String> findIdsOfSimilarProductsById(String id) {
        ResponseEntity<String[]> response = restTemplate.getForEntity(
                productRepositoryConfig.getBaseUrl() + "/product/" + id + "/similarids",
                String[].class
        );
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
