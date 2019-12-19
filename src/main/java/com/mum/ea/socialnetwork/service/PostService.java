package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Post;

import java.util.List;

public interface PostService {
    public Post getPostById(Long postId);
    public void savePost(Post post);
    public List<Post> getAllPosts();
    public void deletePostById(Long postId);
    public List<Post> getPostByPersonId(Long personId);
    List<Post> getAllPostsSorted();

    public List<Post> getUnhealthyPost(String sex);

    public void desablePostById(Long id);

}
