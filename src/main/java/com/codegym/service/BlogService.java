package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Iterable<Blog> findByAll();

    Blog findById(Long id);

    Blog save(Blog blog);

    void delete(Long id);
}
