package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
        @Query(value = "select * from Post where person_id =:id", nativeQuery = true)
        List<Post> findAllPostinThisP(@PathParam("id") long id);
}
