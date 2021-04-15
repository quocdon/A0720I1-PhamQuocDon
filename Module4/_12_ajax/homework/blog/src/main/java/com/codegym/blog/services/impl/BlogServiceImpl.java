package com.codegym.blog.services.impl;

import com.codegym.blog.models.Blog;
import com.codegym.blog.repositories.BlogRepository;
import com.codegym.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    public Page<Blog> findAllByCategory(int category_id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(category_id, pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContains(String title, Pageable pageable) {
        return blogRepository.findBlogsByTitleContains(title, pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContainsAndCategory_Id(String title, int category_id, Pageable pageable) {
        return blogRepository.findBlogsByTitleContainsAndCategory_Id(title, category_id, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(blogRepository.getOne(id));
    }

}
