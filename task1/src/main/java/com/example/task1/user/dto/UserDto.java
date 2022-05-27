package com.example.task1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String permission;
    private String readonly;
    private List<UserBlogDto> blogs;

}
