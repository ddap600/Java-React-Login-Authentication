package com.java_learning.authentication_backend.service;

import com.java_learning.authentication_backend.dto.UserLoginRequestDto;
import com.java_learning.authentication_backend.dto.UserLoginResponseDto;
import com.java_learning.authentication_backend.entity.User;
import com.java_learning.authentication_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
