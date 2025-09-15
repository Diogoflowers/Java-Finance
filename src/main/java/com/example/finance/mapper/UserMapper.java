package com.example.finance.mapper;

import com.example.finance.dto.UserDto;
import com.example.finance.dto.UserResponseDto;
import com.example.finance.model.User;

public class UserMapper {
    public static User toEntity(UserDto dto, String encodedPassword) {
        return User.builder()
                .username(dto.getUsername())
                .password(encodedPassword)
                .build();
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername()
        );
    }
}
