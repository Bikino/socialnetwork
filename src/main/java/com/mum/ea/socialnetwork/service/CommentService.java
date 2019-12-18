package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Comment;

import java.util.List;

public interface CommentService {
    void saveComment(Comment comment);
    List<Comment> findAllComments();



}
