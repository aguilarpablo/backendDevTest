package com.backend.dev.test.infrastructure.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rest.product-repository")
@Getter
@Setter
public class ProductRepositoryConfig {
    private String baseUrl;
}
