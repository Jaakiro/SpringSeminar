package ru.axe.hw3.repository;

import ru.axe.hw3.entity.Product;

import java.util.List;
import java.util.UUID;


public interface ProductRepository {

    Product saveNewProduct(Product product);

    Product findProductById(UUID uuid);

    void deleteProductById(UUID uuid);

    List<Product> findAllProducts();
}
