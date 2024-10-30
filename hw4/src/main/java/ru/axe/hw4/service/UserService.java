package ru.axe.hw4.service;

import ru.axe.hw4.entity.User;

import java.util.List;


public interface UserService {

    User addUser(User user);

    User findUserById(Integer id);

    User updateUser(User updatedUser);

    void deleteUserById(Integer id);

    List<User> findAllUsers();
}
