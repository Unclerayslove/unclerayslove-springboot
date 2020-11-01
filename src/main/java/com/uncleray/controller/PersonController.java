package com.uncleray.controller;

import com.uncleray.entity.Person;
import com.uncleray.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping("/persons")
    public List<Person> getPersons() {

        return service.getPersonList();
    }

}
