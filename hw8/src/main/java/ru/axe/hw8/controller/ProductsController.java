package ru.axe.hw8.controller;

import lombok.AllArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.axe.hw8.aspect.Logger;
import ru.axe.hw8.controller.payload.NewProductPayload;
import ru.axe.hw8.entity.Product;
import ru.axe.hw8.service.ProductService;

@Logger(level = Level.INFO)
@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/list")
    public String findAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products/list";
    }

    @PostMapping
    public String addProduct(@RequestBody Product product, Model model) {
        model.addAttribute(productService.addProduct(product));
        return "products/product";
    }

    @GetMapping("create")
    public String getNewProduct() {
        return "products/product_new";
    }

    @PostMapping("create")
    public String createNewProduct(NewProductPayload payload) {
        try {
            Product product = productService.addProduct(new Product(payload.title(), payload.description()));
            return "redirect:/products/%s".formatted(product.getId());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "products/product_new";
        }
    }
}
