package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Comment;
import com.mum.ea.socialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("comment/all")
    public List<Comment> getAllComments(@RequestBody Comment comment ){

        return commentService.findAllComments();

    }
    @PostMapping("/comment/add")
    public void addComment(@RequestBody Comment comment ){
        commentService.saveComment(comment);
    }

    @GetMapping("/comment/all/{postid}")
    public List<Comment> getAllCommentsById(@PathVariable("postid") long postid){

        return commentService.findallCommentsById(postid);
    }
}
