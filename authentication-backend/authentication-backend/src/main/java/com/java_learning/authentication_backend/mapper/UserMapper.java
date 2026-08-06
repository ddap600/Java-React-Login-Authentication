package com.java_learning.authentication_backend.mapper;

import com.java_learning.authentication_backend.dto.CreateUserRequestDto;
import com.java_learning.authentication_backend.dto.CreateUserResponseDto;
import com.java_learning.authentication_backend.dto.UserDto;
import com.java_learning.authentication_backend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getDisplayName(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getDisplayName(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getRoles()
        );
    }

    public static User mapCreateUserRequestDtoToUser(CreateUserRequestDto createUserDto) {
        return new User(
                createUserDto.getDisplayName(),
                createUserDto.getUsername(),
                createUserDto.getPassword()
        );
    }

    public static User mapToCreateUserResponseToUser(CreateUserRequestDto createUserDto) {
        return new User(
                createUserDto.getDisplayName(),
                createUserDto.getUsername(),
                createUserDto.getPassword()
        );
    }

    public static CreateUserRequestDto mapUserToCreateUserRequestDto(User user) {
        return new CreateUserRequestDto(
                user.getDisplayName(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static CreateUserResponseDto mapUserToCreateUserResponseDto(User user) {
        return new CreateUserResponseDto(
                user.getDisplayName(),
                user.getUsername()
        );
    }

}
