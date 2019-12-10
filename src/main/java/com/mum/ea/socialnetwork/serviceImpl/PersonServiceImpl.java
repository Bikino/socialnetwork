package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.repository.PersonRepository;
import com.mum.ea.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@Resource(name = "PersonService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {

        Person userWithDuplicateUsername = getPersonByUserName(person.getUsername());
        if(userWithDuplicateUsername != null && person.getId() != userWithDuplicateUsername.getId()) {

            throw new RuntimeException("Duplicate username.");
        }
        Person userWithDuplicateEmail = getPersonByEmail(person.getEmail());
        if(userWithDuplicateEmail != null && person.getId() != userWithDuplicateEmail.getId()) {
            throw new RuntimeException("Duplicate email.");
        }
        Set<String> role = new HashSet<String>();
        role.add("USER");
        //person.setRoles(role);
        personRepository.save(person);
    }
    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getPersonByUserName(String userName) {
      return  personRepository.findAllByUserName(userName);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findAllByEmail(email);
    }
}
