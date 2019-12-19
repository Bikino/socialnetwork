package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.UserRoles;
import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.service.PersonService;
import com.mum.ea.socialnetwork.service.UserRolesService;
import com.mum.ea.socialnetwork.service.user_relationService;
import com.mum.ea.socialnetwork.util.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private UserRolesService userRolesService;
    @Autowired
    ServletContext servletContext;

    private String filePath;
    private String fileType;
    private MultipartFile multipartFile;


    private byte[] fileContent;

    private MultipartFile file;

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";





///-----try to save image --------------------------

    @PostMapping("/upload")
    public Person singleFileUpload(@RequestParam("file") MultipartFile file) {
        //Person account = (Person) servletContext.getAttribute(FlyGramConstant.LOGGED_ACCOUNT_PROFILE);
        long userId=1;
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
        UserRoles userRoles= new UserRoles();

        try {
            person.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
            personService.addPerson(person);
           userRoles.setRoleId(1);
           userRoles.setUserId(person.getId());

           userRolesService.saveUserRoles(userRoles);
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

    @GetMapping("/onePersonTest/{id}")
    public Person getOnePersonTest(@PathVariable("id") long id){

        return personService.getPersonById(id);
    }


    @GetMapping("/onePerson/{id}")
    public Person getOnePerson(@PathVariable("id")long id) {
        Person p = new Person();
        long mid = 1;
        try {
           /// System.out.println("printed ");
            p = personService.getPersonById(mid);
           p.setProfilePic(UtilityService.readBytesFromFile(p.getProfilePath()));
            //System.out.println("I've reached....");
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

    ///---- getting one  person --------------
    @GetMapping("/onePersonByUsername/{username}")
    public Person onePersonByUsername(@PathVariable("username")String username) {
        Person p = new Person();

        try {
            /// System.out.println("printed ");
            p = personService.getPersonByUserName(username);
            p.setProfilePic(UtilityService.readBytesFromFile(p.getProfilePath()));
            //System.out.println("I've reached....");
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

   /// @Secured({ROLE_ADMIN})
    @GetMapping(value = "/all")
    public List<Person> getAllPerson(){
        try {
           return personService.getAllPerson();
        }catch (Exception e){

            e.printStackTrace();
            return null;
        }

    }

    @GetMapping(value = "/allperson")
    public List<Person> findAllPersons(){
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
