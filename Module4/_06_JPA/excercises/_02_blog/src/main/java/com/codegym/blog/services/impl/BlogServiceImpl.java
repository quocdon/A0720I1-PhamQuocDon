package com.codegym.blog.services.impl;

import com.codegym.blog.models.Blog;
import com.codegym.blog.repositories.BlogRepository;
import com.codegym.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return null;
    }

    @Override
    public void save(Blog blog) {

    }

    @Override
    public void delete(int id) {

    }
}
