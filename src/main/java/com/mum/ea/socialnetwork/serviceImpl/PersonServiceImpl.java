package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.repository.PersonRepository;
import com.mum.ea.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {

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
}
