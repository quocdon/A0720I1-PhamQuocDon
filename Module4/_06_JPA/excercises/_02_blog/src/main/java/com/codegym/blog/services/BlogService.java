package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
