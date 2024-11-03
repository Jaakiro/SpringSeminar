package ru.axe.hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.axe.hw5.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
