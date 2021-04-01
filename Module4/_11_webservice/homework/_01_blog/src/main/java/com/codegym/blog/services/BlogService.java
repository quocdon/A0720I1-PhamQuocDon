package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory(int category_id, Pageable pageable);
    Page<Blog> findBlogsByTitleContainsOrContentContains(String title, String content, Pageable pageable);
    List<Blog> findAll();
    List<Blog> findAllByCategory(int category_id);
    Blog findById(int id);
    Blog save(Blog blog);
    void delete(int id);
}