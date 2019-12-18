package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.service.CommentService;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminPanelController {

    @Autowired
    PersonService personService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
// === Person ADMIN Starts here==============================

    @GetMapping("/admin/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id){
         personService.deletePersonById(id);
         return "deleted";
    }

    @GetMapping("/admin/person/disable/{id}")
    public Person disableAccount( @PathVariable("id") long id){

        Person personToDesable= personService.getPersonById(id);
        personToDesable.setStatus("disabled");

        return personToDesable;
    }


    @GetMapping("/admin/person/enable/{id}")
    public Person enableAccount( @PathVariable("id") long id){

        Person personToEnable= personService.getPersonById(id);
        personToEnable.setStatus("disabled");

        return personToEnable;
    }




}
