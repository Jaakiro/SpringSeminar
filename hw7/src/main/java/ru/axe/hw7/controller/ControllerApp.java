package ru.axe.hw7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerApp {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/public")
    public String publicPage(){
        return "public";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "private";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @GetMapping("/login")
    public String login(){
        return "login-page";
    }
}
