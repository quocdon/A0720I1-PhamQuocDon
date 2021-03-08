package com.codegym._01_today_picture.Services;

import com.codegym._01_today_picture.models.Comment;
import com.codegym._01_today_picture.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> findAll();

    void save(Comment comment);

    void reactComment(int id);
}
