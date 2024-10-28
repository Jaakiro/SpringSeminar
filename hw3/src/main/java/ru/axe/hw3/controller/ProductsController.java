package ru.axe.hw3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.axe.hw3.entity.Product;
import ru.axe.hw3.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
}
