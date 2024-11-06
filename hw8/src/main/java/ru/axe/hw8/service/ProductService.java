package ru.axe.hw8.service;

import ru.axe.hw8.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    Product findProductById(Integer id);

    List<Product> findAllProducts();

    Product updateProduct(Product updatedProduct);

    void deleteProductById(Integer id);

}
