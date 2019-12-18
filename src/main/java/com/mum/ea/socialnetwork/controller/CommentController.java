package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Comment;
import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("comment/all")
    public List<Comment> getAllComments(Comment comment ){
        return commentService.findAllComments();

    }
    @GetMapping("comments/all/{id}")
    public List<Comment> getAllCommentsForPost(@PathVariable("id") Long id){
        List<Comment> commentList = new ArrayList<>();
        for(Comment c : commentService.findAllComments()){
            if(c.getPost().getPostId()==id){
                commentList.add(c);
            }
        }
        return commentList;
    }
    @PostMapping("/comment/add")
    public void addComment(@RequestBody Comment comment ){
        commentService.saveComment(comment);
    }
}
