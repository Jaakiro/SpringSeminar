package ru.axe.manager.client;

import ru.axe.manager.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRestClient {

    List<Product> findAllProducts();

    Product createProduct(String title, String description);

    Optional<Product> findProduct(Integer id);

    void updateProduct(Integer id, String title, String description);

    void deleteProduct(Integer id);
}
