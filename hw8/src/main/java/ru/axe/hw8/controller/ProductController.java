package ru.axe.hw8.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.axe.hw8.aspect.Logger;
import ru.axe.hw8.controller.payload.UpdateProductPayload;
import ru.axe.hw8.entity.Product;
import ru.axe.hw8.service.ProductService;

import java.util.Locale;
import java.util.NoSuchElementException;

@Logger(level = Level.INFO)
@Controller
@RequestMapping("/products/{id:\\d+}")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    @GetMapping
    public String findProductById(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/product";
    }

    @GetMapping("/edit")
    public String editProduct(@PathVariable Integer id,
                              Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/product_edit";
    }

    @PostMapping("/edit")
    public String updateUserById(@PathVariable Integer id,
                                 UpdateProductPayload payload,
                                 Model model) {
        model.addAttribute("product", productService.updateProduct(
                new Product(id, payload.title(), payload.description())));
        return "products/product_edit";
    }

    @PostMapping("/delete")
    public String deleteUserById(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/products/list";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException exception,
                                               Model model, HttpServletResponse response,
                                               Locale locale){
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error",
                this.messageSource.getMessage(exception.getMessage(), new Object[0],
                        exception.getMessage(), locale));
        return "errors/404";
    }
}
