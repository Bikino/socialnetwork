package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {

}
