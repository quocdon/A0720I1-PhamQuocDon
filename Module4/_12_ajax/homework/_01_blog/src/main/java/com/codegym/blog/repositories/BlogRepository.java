package com.codegym.blog.repositories;

import com.codegym.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Override
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByCategory_Id(int category_id, Pageable pageable);

    Page<Blog> findAllByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    Page<Blog> findBlogsByTitleContainsOrContentContains(String title, String content, Pageable pageable);

}
