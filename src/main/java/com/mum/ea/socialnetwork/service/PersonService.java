package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void savePerson(Person person);
    Person getPersonById(Long id);
    List<Person> getAllPerson();
    Person getPersonByUserName(String userName);
    Person getPersonByEmail(String email);
    void deletePersonById(Long personId);
    Person updatePerson(Person personToSave);
    Person addPerson(Person person);

    List<Person> findAllByIdNotIn(List<Long>users);
    List<Person> findAllByIdIn(List<Long>users);

}
