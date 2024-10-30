package ru.axe.hw4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.axe.hw4.controller.payload.UpdateUserPayload;
import ru.axe.hw4.entity.User;
import ru.axe.hw4.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String findUserById(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "users/user";
    }

    @PostMapping
    public String addUser(@RequestBody User user, Model model) {
        model.addAttribute(userService.addUser(user));
        return "users/user";
    }

    @GetMapping("/{id}/edit")
    public  String getUserEdit(@PathVariable Integer id,
                               Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "users/user_edit";
    }

    @PostMapping("/{id}/edit")
    public String updateUserById(@PathVariable Integer id,
                                 UpdateUserPayload payload,
                                 Model model) {
        model.addAttribute("user", userService.updateUser(
                new User(id, payload.name(), payload.email())));
        return "users/user_edit";
    }

    @PostMapping("/{id}/delete")
    public String deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "redirect:/users/list";
    }
}
