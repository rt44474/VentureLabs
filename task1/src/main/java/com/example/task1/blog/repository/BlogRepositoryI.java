package com.example.task1.blog.repository;

import com.example.task1.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepositoryI extends JpaRepository<Blog, Long> {
}
