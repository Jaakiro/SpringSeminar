package ru.axe.hw6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.axe.hw6.entity.User;
import ru.axe.hw6.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private UserRepository usersRepository;


    public User addUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return usersRepository.findById(id);
    }

    @Override
    public User updateUser(User updatedUser) {
        return usersRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersRepository.deleteById(id);
    }
}
