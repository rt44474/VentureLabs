package com.example.task1.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogDto {
    private Long id;
    private Long user_id;
    private String text;
}
