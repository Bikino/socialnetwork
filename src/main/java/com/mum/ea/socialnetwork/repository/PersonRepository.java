package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p WHERE username = :username")
    Person findAllByUserName(@PathParam("username") String username);

    @Query(value = "SELECT p FROM Person p WHERE email = :email")
    Person findAllByEmail(@PathParam("email") String email);

    List<Person> findAllByIdNotIn(List<Long>users);

    List<Person> findAllByIdIn(List<Long>users);
}
