package ru.axe.hw4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.axe.hw4.entity.User;
import ru.axe.hw4.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private UserRepository usersRepository;


    public User addUser(User user) {
        return usersRepository.add(user);
    }

    @Override
    public List<User> findAllUsers() {
        return usersRepository.getAll();
    }

    @Override
    public User findUserById(Integer id) {
        return usersRepository.getById(id);
    }

    @Override
    public User updateUser(User updatedUser) {
        return usersRepository.add(updatedUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersRepository.delete(id);
    }
}
