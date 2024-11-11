package ru.axe.manager.client;


import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import ru.axe.manager.controller.payload.NewProductPayload;
import ru.axe.manager.controller.payload.UpdateProductPayload;
import ru.axe.manager.entity.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
public class ProductsRestClientImp implements ProductsRestClient {

    private static final ParameterizedTypeReference<List<Product>> PRODUCTS_TYPE_REFERENCE =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;

    @Override
    public List<Product> findAllProducts() {
        return this.restClient
                .get()
                .uri("/catalogue-api/products")
                .retrieve()
                .body(PRODUCTS_TYPE_REFERENCE);
    }

    @Override
    public Product createProduct(String title, String description) {
        try {
            return this.restClient
                    .post()
                    .uri("/catalogue-api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new NewProductPayload(title, description))
                    .retrieve()
                    .body(Product.class);
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public Optional<Product> findProduct(Integer id) {
        try {
            return Optional.ofNullable(this.restClient
                    .get()
                    .uri("/catalogue-api/products/{id}", id)
                    .retrieve()
                    .body(Product.class));
        } catch (HttpClientErrorException.NotFound exception) {
            return Optional.empty();
        }
    }

    @Override
    public void updateProduct(Integer id, String title, String description) {
        try {
            this.restClient
                    .patch()
                    .uri("/catalogue-api/products/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new UpdateProductPayload(title, description))
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try {
            this.restClient
                    .delete()
                    .uri("/catalogue-api/products/{id}", id)
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound exception) {
            throw new NoSuchElementException(exception);
        }
    }
}
