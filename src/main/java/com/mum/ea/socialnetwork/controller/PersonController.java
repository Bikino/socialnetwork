package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.util.UtilityConfig;
import com.mum.ea.socialnetwork.service.user_relationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {

    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;

    @Autowired
    private PersonService personService;
    @Autowired
    private user_relationService user_relation_service;

    ///---- saving a person --------------
    @PostMapping("/saveperson")
    public String savePerson(@RequestBody Person person) {
        String message = "";
        if(fileType.startsWith("image")) {
            filePath = UtilityConfig.savingPic(multipartFile);
            person.setProfilePicture(filePath);
            personService.savePerson(person);
            message="Saved Successfully";
        }else{
            message= "Invalid Picture";
        }
        return message;
    }
//---- saving Picture -------------------
    @PostMapping("/savepicture")
    public void savePic(@RequestParam("file") MultipartFile file) {
        try{
            multipartFile= file;
            fileType = file.getContentType();

        }catch (Exception e){
            e.printStackTrace();
        }

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


    ///---- getting one  person --------------
    @GetMapping(value = "/onePerson")
    public Person getOnePerson(@RequestParam Long id) {
        return personService.getPersonById(id);

    }
///------ save edited profile --------------
    @PostMapping(value ="/editPerson")
    public void editPersonInfo(@RequestBody Person person) {
       // String message = "";

//        try {
//
//            Optional<Person> person1 = Optional.ofNullable(personService.getPersonById(id));
//            if (!person1.isPresent()) {
//                message = "The person is not present";
//                return message;
//            }
            personService.savePerson(person);
//            message = "Person updated";
//            return message;
//
//        } catch (Exception e) {
//            e.getMessage();
//
//        }

        //return null;
    }


}

