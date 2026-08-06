package com.java_learning.authentication_backend.service;

import com.java_learning.authentication_backend.dto.CreateUserRequestDto;
import com.java_learning.authentication_backend.dto.CreateUserResponseDto;
import com.java_learning.authentication_backend.entity.User;
import com.java_learning.authentication_backend.mapper.UserMapper;
import com.java_learning.authentication_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public CreateUserResponseDto createUser(CreateUserRequestDto createUserDto) {

        User user = UserMapper.mapCreateUserRequestDtoToUser(createUserDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapUserToCreateUserResponseDto(savedUser);
    }
}
