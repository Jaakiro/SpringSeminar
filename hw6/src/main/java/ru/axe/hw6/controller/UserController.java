package ru.axe.hw6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.axe.hw6.controller.payload.NewUserPayload;
import ru.axe.hw6.controller.payload.UpdateUserPayload;
import ru.axe.hw6.entity.User;
import ru.axe.hw6.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> response = userService.findAllUsers();
        return response != null && !response.isEmpty()
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        Optional<User> response = userService.findUserById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody NewUserPayload payload) {
        return new ResponseEntity<>(userService.addUser(
                new User(payload.name(), payload.email())), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Integer id,
                                               @RequestBody UpdateUserPayload payload) {
        Optional<User> response = userService.findUserById(id);
            return response.isPresent()
            ? new ResponseEntity<>(userService.addUser(
                    new User(id, payload.name(), payload.email())), HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }
}
