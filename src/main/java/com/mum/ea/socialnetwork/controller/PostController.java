package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/save")
    public void addPost(@RequestBody Post post ){
        postService.savePost(post);

    }

    @GetMapping("/post/all")
    public List<Post> listAllPosts(@RequestBody Post post){

        return postService.getAllPosts();
    }

}
