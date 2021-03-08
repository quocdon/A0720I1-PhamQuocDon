package com.codegym._01_today_picture.repositories;

import com.codegym._01_today_picture.models.Comment;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository <Comment, Integer> {
}
