package com.k.solutions.springsessionmgmt.controllers;

import com.k.solutions.springsessionmgmt.entities.Person;
import com.k.solutions.springsessionmgmt.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLDataException;
import java.sql.SQLException;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/person")
    public Person addPerson(@RequestBody Person person) throws SQLException {

            return personService.addPerson(person);
    }
}
