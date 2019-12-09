package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.util.UtilityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;

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

    ///---- getting list of person registered--------------
    @GetMapping(value = "/all")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
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
