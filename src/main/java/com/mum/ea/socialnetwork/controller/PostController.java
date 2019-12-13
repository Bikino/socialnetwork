package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/post/save")
    public void addPost(@RequestBody Post post ){
        System.out.println("hello there");
        postService.savePost(post);

    }

    @GetMapping("/post/getall")
    public List<Post> listAllPosts(@RequestBody Post post){

        return postService.getAllPosts();
    }

}
