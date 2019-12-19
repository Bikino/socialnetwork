package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.service.PostService;
import com.mum.ea.socialnetwork.util.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;

    private byte[] fileContent;

    private MultipartFile mfile;

    private String filePath;

///-----try to save image --------------------------

    @PostMapping("/getpicture")
    public void myUpload(@RequestParam("file") MultipartFile file) {

        try {
            filePath=UtilityService.saveFileToFolder(file);
            this.mfile = file;
        } catch (Exception e) {
            e.printStackTrace();

        }


    }





    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public MultipartFile getFile() {
        return mfile;
    }

    public void setFile(MultipartFile file) {
        this.mfile = file;
    }

    ///////------end of upload file test ----------





    @PostMapping(value = "/post/save")
    public void addPost(@RequestBody Post post ){

        post.setProfilePath(filePath);
        post.setStatus("Enabled");
        post.setPostType(mfile.getContentType());
        postService.savePost(post);
    }

    @GetMapping("/post/getall")
    public List<Post> listAllPosts(){

        List<Post> myPosts= postService.getAllPostsSorted();
        List<Post> lastUp = new ArrayList<>();
     // myPosts.forEach(post-> {
        Post post = new Post();
          try {
              for(Post pp : myPosts) {
                  pp.setProfilePic(UtilityService.readBytesFromFile(pp.getProfilePath()));
                  lastUp.add(pp);
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
    //  });

        return lastUp;
    }

    @GetMapping("/timeline/{id}")
    public List<Post> postsPerPerson(@PathVariable("id") Long personId){
        System.out.println("hello thereeee");
        return postService.getPostByPersonId(personId);
    }

    @GetMapping("/unhealthy")
    public List<Post> findAllUnhealthypost(){
        String s = "sex";
        return postService.getUnhealthyPost(s);
    }

    @PostMapping("/disablepost/{id}")
    public Post desablePost(@PathVariable("id") Long id){
        try {
            Post p = postService.getPostById(id);
            p.setStatus("Disabled");
            postService.savePost(p);
            System.out.println("I am here...");
            return p;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }




}
