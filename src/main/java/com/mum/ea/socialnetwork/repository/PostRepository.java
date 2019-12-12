package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {

//    @Query("select from Post where ")
//    public Post searchUnhealthyPost(@PathParam("unhealthy") String unhealthy);



}
