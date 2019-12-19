package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Post;

import java.util.List;

public interface PostService {
    Post getPostById(Long postId);
    void savePost(Post post);
    List<Post> getAllPosts();
    void deletePostById(Long postId);
    List<Post> getPostByPersonId(Long personId);
    List<Post> getAllPostsSorted();

    List<Post> getUnhealthyPost(String sex);

    void desablePostById(Long id);

}
