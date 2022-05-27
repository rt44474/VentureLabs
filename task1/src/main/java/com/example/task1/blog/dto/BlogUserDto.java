package com.example.task1.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogUserDto {
    private Long id;
    private String username;
    private String password;
    private String permission;
    private String readonly;
}
