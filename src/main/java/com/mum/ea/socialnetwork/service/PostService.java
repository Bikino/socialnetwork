package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Post;

import java.util.List;

public interface PostService {
    public Post getPostById(Long postId);
    public void savePost(Post post);
    public List<Post> getAllPosts();

}
