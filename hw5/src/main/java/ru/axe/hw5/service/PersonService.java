package ru.axe.hw5.service;

import ru.axe.hw5.entity.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {

    Person addPerson(Person person);

    Optional<Person> findPersonById(Integer id);

    List<Person> findAllPersons();

    Person updatePersonById(Person person);

    void deletePersonById(Integer id);
}
