package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.domain.Post;
import com.mum.ea.socialnetwork.repository.PostRepository;
import com.mum.ea.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Override
    public Post getPostById(Long postId ) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public void deletePostById(Long postId) {
         postRepository.deleteById(postId);
    }

    @Override
    public List<Post> getPostByPersonId(Long personId) {
        return postRepository.findAllPostinThisP(personId);
    }

    @Override

    public List<Post> getAllPostsSorted() {
        return postRepository.findAllInOrder();

    }
    @Override
    public List<Post> getUnhealthyPost(String sex) {
        return postRepository.searchUnhealthyPost(sex);

    }


}
