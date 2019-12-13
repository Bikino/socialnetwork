package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value = "/post/save")
    public void addPost(@RequestBody Post post ){
        System.out.println("hello there");
        post.setLocalDateTime(LocalDateTime.now());
        postService.savePost(post);

    }
    @GetMapping("/post/getall")
    public List<Post> listAllPosts(){
        System.out.println("Display is happening");
        return postService.getAllPosts();

    }

    @GetMapping("/getpost/{post_id}")
    public Post getPost(@PathVariable("post_id") Long id){
        System.out.println("I am fine");
        return postService.getPostById(id);
    }

}
