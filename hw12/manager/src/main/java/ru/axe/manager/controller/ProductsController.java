package ru.axe.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.axe.manager.client.BadRequestException;
import ru.axe.manager.client.ProductsRestClient;
import ru.axe.manager.controller.payload.NewProductPayload;
import ru.axe.manager.entity.Product;


@Controller
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductsController {

    private final ProductsRestClient productsRestClient;

    @GetMapping("list")
    public String getProductsList(Model model) {
        model.addAttribute("products", this.productsRestClient.findAllProducts());
        return "products/list";
    }

    @GetMapping("create")
    public String getNewProduct() {
        return "products/product_new";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload,
                                Model model) {
        try {
            Product product = this.productsRestClient.createProduct(payload.title(), payload.description());
            return "redirect:/products/%d".formatted(product.id());
        } catch (BadRequestException exception) {
            model.addAttribute("payload", payload);
            model.addAttribute("errors", exception.getErrors());
            return "products/product_new";
        }
    }
}
