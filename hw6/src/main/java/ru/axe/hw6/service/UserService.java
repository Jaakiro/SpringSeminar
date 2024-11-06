package ru.axe.hw6.service;

import ru.axe.hw6.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User addUser(User user);

    Optional<User> findUserById(Integer id);

    User updateUser(User updatedUser);

    void deleteUserById(Integer id);

    List<User> findAllUsers();
}
