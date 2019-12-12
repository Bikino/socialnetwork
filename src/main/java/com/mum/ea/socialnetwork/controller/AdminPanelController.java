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
    @GetMapping("/admin/person/all")
    public List<Person> getAllPerson(@RequestBody Person person){
        return personService.getAllPerson();
    }

    @GetMapping("/admin/person/{id}")
    public Person getPerson(@PathVariable("id") Long id){
       return personService.getPersonById(id);
    }
    @GetMapping("/admin/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id){
         personService.deletePersonById(id);
         return "deleted";
    }
}
