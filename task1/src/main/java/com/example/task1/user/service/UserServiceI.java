package com.example.task1.user.service;

import com.example.task1.user.dto.UserDto;
import com.example.task1.user.entity.User;

public interface UserServiceI {

    UserDto findUserByUsername(String username);

    User addUser(String username, String password, String permission, String readonly);
}
