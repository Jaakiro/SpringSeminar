package ru.axe.hw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.axe.hw3.entity.Product;
import ru.axe.hw3.repository.ProductRepository;

import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addNewProduct(Product product) {
        return productRepository.saveNewProduct(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product findProductById(UUID uuid) {
        return productRepository.findProductById(uuid);
    }

    @Override
    public Product updateProduct(Product oldProduct, Product updatedProduct) {
        updatedProduct.setId(oldProduct.getId());
        return productRepository.saveNewProduct(updatedProduct);
    }

    @Override
    public void deleteProductById(UUID uuid) {
        productRepository.deleteProductById(uuid);
    }
}
