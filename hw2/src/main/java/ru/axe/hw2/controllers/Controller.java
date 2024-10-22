package ru.axe.hw2.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping()
    public String welcome() {
        return "Hello user";
    }
}
