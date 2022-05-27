package com.example.task1.blog.mappers;

import com.example.task1.blog.dto.BlogDto;
import com.example.task1.blog.entity.Blog;
import org.mapstruct.Mapper;

@Mapper
public interface BlogMapper {
    BlogDto toDto(Blog blog);

    Blog fromDto(BlogDto blogDto);
}
