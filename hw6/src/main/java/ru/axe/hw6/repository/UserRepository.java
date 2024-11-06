package ru.axe.hw6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.axe.hw6.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
}
