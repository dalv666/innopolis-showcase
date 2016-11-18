package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Person;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.PersonService;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List getCities() {
        List<Person> all = personService.findAll();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/person/{id}")
    public Person getCustomers(@PathVariable long id) {
        return personService.findById(id);
    }

}
