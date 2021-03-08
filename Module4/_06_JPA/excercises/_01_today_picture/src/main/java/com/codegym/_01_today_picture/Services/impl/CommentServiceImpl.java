package com.codegym._01_today_picture.Services.impl;

import com.codegym._01_today_picture.Services.CommentService;
import com.codegym._01_today_picture.models.Comment;
import com.codegym._01_today_picture.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void reactComment(int id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        comment.setReaction(comment.getReaction() + 1);
        commentRepository.save(comment);
    }
}
