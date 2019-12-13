package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Comment;

import java.util.List;

public interface CommentService {
    public void saveComment(Comment comment);
    public List<Comment> findAllComments();
    public  List<Comment> findallCommentsById(Long postid);



}
