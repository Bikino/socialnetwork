package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.repository.PersonRepository;
import com.mum.ea.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "PersonService")
@Transactional
public class PersonServiceImpl implements UserDetailsService, PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePerson(Person person) {

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
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }



    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public Person updatePerson(Person personToSave) {
        return personRepository.save(personToSave);
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonByUserName(String userName) {
      return  personRepository.findAllByUserName(userName);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findAllByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = getPersonByUserName(username);
        if(user == null){
            return null;
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set getAuthority(Person user) {
        Set authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    @Override
    public List<Person> findAllByIdNotIn(List<Long> users) {
        return personRepository.findAllByIdNotIn(users);
    }

    @Override
    public List<Person> findAllByIdIn(List<Long> users) {
        return personRepository.findAllByIdIn(users);
    }
}
