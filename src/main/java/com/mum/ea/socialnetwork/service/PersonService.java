package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public void savePerson(Person person);
    public Person getPersonById(Long id);
    public List<Person> getAllPerson();
    public void deletePersonById(Long personId);



}
