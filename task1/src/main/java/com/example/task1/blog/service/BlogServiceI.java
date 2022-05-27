package com.example.task1.blog.service;

import com.example.task1.blog.dto.BlogDto;
import com.example.task1.blog.entity.Blog;

import java.util.List;

public interface BlogServiceI {
    List<BlogDto> getAll();

    Blog addBlog(String text);

    void delete(Long id);
}
