package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.user_relationService;
import com.mum.ea.socialnetwork.util.FlyGramConstant;
import com.mum.ea.socialnetwork.util.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private user_relationService user_relation_service;

    @Autowired
    ServletContext servletContext;

    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;


    private byte[] fileContent;

    private MultipartFile file;






///-----try to save image --------------------------

    @PostMapping("/upload")
    public Person singleFileUpload(@RequestParam("file") MultipartFile file) {
        //Person account = (Person) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
        long userId=15;
        Person account=personService.getPersonById(userId);
        try {
            account.setProfilePath(UtilityService.saveFileToFolder(file));
            Person acc = personService.updatePerson(account);
            acc.setProfilePic(UtilityService.readBytesFromFile(acc.getProfilePath()));
            return acc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }





    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    ///////------end of upload file test ----------



    @PostMapping("/saveperson")
    public Person savePerson(@RequestBody Person person) {
        try {

            personService.addPerson(person);
          //  System.out.println("2222");
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
    @GetMapping("/onePerson/{id}")
    public Person getOnePerson(@PathVariable("id")long id) {
        Person p = new Person();
        try {
            System.out.println("printed ");
            p = personService.getPersonById(id);
            p.setProfilePic(UtilityService.readBytesFromFile(p.getProfilePath()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }




    ///------ save edited profile --------------
    @PutMapping(value = "/updateperson/{id}")
    public Person updatePerson( @PathVariable("id")long id, @RequestBody Person person) {
        Person personExist= personService.getPersonById(id);
        personExist.setFirstName(person.getFirstName());
        personExist.setLastName(person.getLastName());
        personExist.setAddressCity(person.getAddressCity());
        personExist.setAddressState(person.getAddressState());
        personExist.setEmail(person.getEmail());
        personExist.setBio(person.getBio());
        personExist.setGender(person.getGender());
        personExist.setPhoneNumber(person.getPhoneNumber());
        personExist.setId(id);
        personExist.setProfilePic(fileContent);
        Person personToSave =personExist;

        return personService.updatePerson(personToSave);
    }


    @GetMapping(value = "/all")
    public List<Person> getAllPerson(){
        try {
           return personService.getAllPerson();
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }

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
