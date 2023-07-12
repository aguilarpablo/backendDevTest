package com.backend.dev.test.application;

import com.backend.dev.test.domain.model.Product;
import com.backend.dev.test.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductApplicationService {
    private final ProductRepository productRepository;

    public List<Product> getSimilarProductsByProductId(String id) {
        List<String> similarProductsId = productRepository.findIdsOfSimilarProductsById(id);
        return similarProductsId.stream()
                .map(productRepository::findById)
                .filter(Objects::nonNull)
                .toList();
    }

}
