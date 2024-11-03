package ru.axe.hw5.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.axe.hw5.controller.payload.NewPersonPayload;
import ru.axe.hw5.controller.payload.UpdatePersonPayload;
import ru.axe.hw5.entity.Person;
import ru.axe.hw5.service.PersonService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public Person create(@RequestBody NewPersonPayload payload){
        return personService.addPerson(new Person(null, payload.name(), payload.age()));
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Integer id){
        return personService.findPersonById(id).get();
    }

    @GetMapping("/list")
    public List<Person> findAllPersons(){
        return personService.findAllPersons();
    }

    @PutMapping("/{id}")
    public Person updatePersonById(@PathVariable Integer id, @RequestBody UpdatePersonPayload payload){
        return personService.updatePersonById(new Person(id, payload.name(), payload.age()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        personService.deletePersonById(id);
    }
}
