package ru.axe.hw4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.axe.hw4.controller.payload.NewUserPayload;
import ru.axe.hw4.entity.User;
import ru.axe.hw4.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/list";
    }

    @GetMapping("create")
    public String getNewUser() {
        return "users/user_new";
    }

    @PostMapping("create")
    public String createNewUser(NewUserPayload payload) {
        try {
            User user = this.userService.addUser(new User(null, payload.name(), payload.email()));
            return "redirect:/users/%s" .formatted(user.getId());
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "users/user_new";
        }
    }
}
