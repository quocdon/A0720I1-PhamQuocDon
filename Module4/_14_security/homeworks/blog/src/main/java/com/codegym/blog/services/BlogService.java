package com.codegym.blog.services;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory(int category_id, Pageable pageable);
    Page<Blog> findAllByTitleContains(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainsAndCategory_Id(String title, int category_id, Pageable pageable);
    Blog findById(int id);
    Blog save(Blog blog);
    void delete(int id);
}
