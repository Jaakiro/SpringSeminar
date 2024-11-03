package ru.axe.hw5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.axe.hw5.entity.Person;
import ru.axe.hw5.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findPersonById(Integer id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePersonById(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }
}
