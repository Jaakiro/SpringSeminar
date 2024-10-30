package ru.axe.hw4.repository;

import ru.axe.hw4.entity.User;
import ru.axe.hw4.repository.db.Repository;

import java.util.List;


public interface UserRepository extends Repository<User, Integer> {

    User add(User user);

    List<User> getAll();

    User getById(Integer id);

    void delete(Integer id);

}
