package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.user_relationService;
import com.mum.ea.socialnetwork.util.UtilityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private user_relationService user_relation_service;

    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;


    ///---- saving a person --------------
    @PostMapping("/saveperson")
    public void savePerson(@RequestBody Person person) {

        personService.addPerson(person);
    }

    //---- saving Picture -------------------
    @PostMapping("/savepicture")
    public void savePic(@RequestParam("file") MultipartFile file) {
        try {
            multipartFile = file;
            fileType = file.getContentType();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    ///---- getting one  person --------------
    @GetMapping(value = "/onePerson")
    public Person getOnePerson(@RequestParam Long id) {
        return personService.getPersonById(id);

    }

    ///------ save edited profile --------------
    @PostMapping(value = "/editPerson")
    public void editPersonInfo(@RequestBody Person person) {

        personService.addPerson(person);

    }





    @GetMapping(value = "/all")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }



    @RequestMapping(value="/sendRequest", method = RequestMethod.POST)
    public void sendRequest(@RequestParam("requested_by") String requested_by,
                            @RequestParam("requested_to") String requested_to){


        user_relation ur = new user_relation();
        ur.setUser_id_1(Integer.valueOf(requested_by));
        ur.setUser_id_2(Integer.valueOf(requested_to));
        ur.setAction_initiated(Integer.valueOf(requested_by));
        System.out.println(ur);
        user_relation_service.save(ur);

    }

    @RequestMapping(value="/getNoOfFollowersOrPendig/{status}", method = RequestMethod.GET)
    public long getNoOfFollowersOrPendig(@PathVariable("status") int status){
        return user_relation_service.noOfFollowers_or_pendingRequest(status);
    }

    @RequestMapping(value = "/getUserTypesByStatus/{status}", method = RequestMethod.GET)
    public List<user_relation> getUserTypesByStatus(@PathVariable("status") int status){
        return user_relation_service.getUserTypesByStatus(status);
    }
}
