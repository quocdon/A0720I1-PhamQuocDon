package com.codegym.service;

import com.codegym.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> findAll();
    Comment findById(long id);
    void save(Comment comment);
    void like(long id);
}
