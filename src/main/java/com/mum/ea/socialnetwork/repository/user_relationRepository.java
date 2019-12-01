package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.user_relation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_relationRepository extends CrudRepository<user_relation, Long> {
}
