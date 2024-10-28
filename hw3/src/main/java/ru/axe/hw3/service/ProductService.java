package ru.axe.hw3.service;

import ru.axe.hw3.entity.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    Product addNewProduct(Product product);

    Product findProductById(UUID uuid);

    Product updateProduct(Product oldProduct, Product updatedProduct);

    void deleteProductById(UUID uuid);

    List<Product> findAllProducts();
}
