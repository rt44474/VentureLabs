package com.example.task1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserBlogDto {
    private Long id;
    private String text;
}
