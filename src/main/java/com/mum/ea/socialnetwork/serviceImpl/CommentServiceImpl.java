package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Comment;
import com.mum.ea.socialnetwork.repository.CommentRepository;
import com.mum.ea.socialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Optional<Comment> findCommentById(Long id){
        return commentRepository.findById(id);
    }
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public List<Comment> findallCommentsById(Long postid) {
        return commentRepository.findCommentByPostPostId(postid);
    }
}
