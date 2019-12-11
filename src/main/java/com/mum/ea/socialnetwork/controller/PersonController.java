package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.user_relationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private user_relationService user_relation_service;
    @PostMapping(value = "/save")
    public void savePerson(@RequestBody Person person){
        personService.addPerson(person);

    }

    @GetMapping(value = "/all")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

//    @RequestMapping(value="/sendRequest", method = RequestMethod.POST)
//    public void sendRequest(@RequestParam("requested_by") String requested_by,
//                            @RequestParam("requested_to") String requested_to){
//
//        System.out.println("====================================================================");
//        System.out.println(requested_by + "  " + requested_to);
//        user_relation ur = new user_relation();
//        ur.setUser_id_1(Integer.valueOf(requested_by));
//        ur.setUser_id_2(Integer.valueOf(requested_to));
//        ur.setAction_initiated(Integer.valueOf(requested_by));
//        System.out.println(ur);
//        user_relation_service.save(ur);
//    }
}

