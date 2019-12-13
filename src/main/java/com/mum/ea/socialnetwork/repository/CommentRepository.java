package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    public List<Comment> findCommentByPostPostId(long postid);
}
