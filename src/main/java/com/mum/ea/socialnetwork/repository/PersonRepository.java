package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
