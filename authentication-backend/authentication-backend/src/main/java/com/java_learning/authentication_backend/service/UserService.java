package com.java_learning.authentication_backend.service;

import com.java_learning.authentication_backend.dto.CreateUserRequestDto;
import com.java_learning.authentication_backend.dto.CreateUserResponseDto;
import com.java_learning.authentication_backend.dto.UserLoginRequestDto;
import com.java_learning.authentication_backend.dto.UserLoginResponseDto;
import com.java_learning.authentication_backend.entity.User;
import com.java_learning.authentication_backend.mapper.UserMapper;
import com.java_learning.authentication_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {

        User user = UserMapper.mapCreateUserRequestDtoToUser(createUserRequestDto);
        user.setPassword(
                passwordEncoder.encode(createUserRequestDto.getPassword())
        );

        User savedUser = userRepository.save(user);

        return UserMapper.mapUserToCreateUserResponseDto(savedUser);
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {

        User user = userRepository
                .findByUsername(userLoginRequestDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean passwordMatches =
                passwordEncoder.matches(
                        userLoginRequestDto.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            return new UserLoginResponseDto(
                    false,
                    "Password does not match"
            );
        }

        return new UserLoginResponseDto(
                true,
                "Login successfull"
        );
    }
}
