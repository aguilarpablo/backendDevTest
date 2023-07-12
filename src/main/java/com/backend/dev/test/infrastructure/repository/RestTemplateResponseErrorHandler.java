package com.backend.dev.test.infrastructure.repository;

import com.backend.dev.test.domain.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is5xxServerError()) {
            // handle SERVER_ERROR
        } else if (response.getStatusCode().is4xxClientError()) {
            // handle CLIENT_ERROR
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ProductNotFoundException("Product Not found");
            }
        }
    }
}
