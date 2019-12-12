package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.user_relationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private user_relationService user_relation_service;

    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;


    @PostMapping("/saveperson")
    public Person savePerson(@RequestBody Person person) {
        try {

            personService.addPerson(person);
            System.out.println("2222");
            return person;
        }catch (Exception e){
            e.printStackTrace();
          return null;
        }
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
    @GetMapping(value = "/onePerson/{id}")
    public Person getOnePerson(@PathVariable("id")long id) {
        return personService.getPersonById(id);

    }

    ///------ save edited profile --------------
    @PutMapping(value = "/editPerson/{id}")
    public Person editPersonInfo( @PathVariable("id")long id, @RequestBody Person person) {

        return personService.updatePerson(person );
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
