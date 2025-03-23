package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Person;

@RestController
public class PersonController {
    private final List<Person> persons = new ArrayList<>();

    @GetMapping("/person")
    public List<Person> getPerson() {
        return this.persons;
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonbyId(@PathVariable int id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst();
    }


    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        this.persons.add(person);
        return person;
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        int index = - 1;
        for (Person p : persons) {
            if (p.getId() == id) {
                index = persons.indexOf(p);
                persons.set(index, person);
            }
        }
        return index == -1 ? addPerson(person) : person;
    }
}
