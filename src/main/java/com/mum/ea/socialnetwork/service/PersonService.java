package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Person;

import java.util.List;

public interface PersonService {
    public void addPerson(Person person);
    public Person getPersonById(Long id);
    public List<Person> getAllPerson();
    public Person getPersonByUserName(String userName);
    public Person getPersonByEmail(String email);

}
