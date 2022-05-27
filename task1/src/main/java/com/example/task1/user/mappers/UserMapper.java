package com.example.task1.user.mappers;

import com.example.task1.user.dto.UserDto;
import com.example.task1.user.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
