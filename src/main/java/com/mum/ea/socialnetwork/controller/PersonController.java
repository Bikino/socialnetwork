package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/person/save")
    public void savePerson(@RequestBody Person person){
        personService.addPerson(person);

    }

    @GetMapping(value = "person/all")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
}
