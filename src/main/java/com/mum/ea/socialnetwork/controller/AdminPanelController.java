package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.service.CommentService;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class AdminPanelController {
    final String ROLE_ADMIN = "ROLE_ADMIN";
    @Autowired
    PersonService personService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
// === Person ADMIN Starts here==============================

     @Secured({ROLE_ADMIN})
    @GetMapping("/admin/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id){
         personService.deletePersonById(id);
         return "deleted";
    }

    @Secured({ROLE_ADMIN})
    @GetMapping("/admin/person/disable/{id}")
    public Person disableAccount( @PathVariable("id") long id){

        Person personToDesable= personService.getPersonById(id);
        personToDesable.setStatus("disabled");

        return personToDesable;
    }

    @Secured({ROLE_ADMIN})
    @GetMapping("/admin/person/enable/{id}")
    public Person enableAccount( @PathVariable("id") long id){

        Person personToEnable= personService.getPersonById(id);
        personToEnable.setStatus("disabled");

        return personToEnable;
    }




}
