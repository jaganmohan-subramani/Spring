package com.commerce.userservice.controller;

import com.commerce.userservice.model.Person;
import com.commerce.userservice.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Flux<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable Long id) {
        return personRepository.findById(id);
    }
}
