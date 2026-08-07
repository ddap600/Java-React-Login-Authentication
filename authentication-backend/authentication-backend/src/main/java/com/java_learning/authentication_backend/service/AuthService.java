package com.java_learning.authentication_backend.service;

import com.java_learning.authentication_backend.dto.UserLoginRequestDto;
import com.java_learning.authentication_backend.dto.UserLoginResponseDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userLoginRequestDto.getUsername(),
                                userLoginRequestDto.getPassword()
                        )
                );

        String token = jwtService.generateToken(
                (UserDetails) authentication.getPrincipal()
        );

        return new UserLoginResponseDto(
                true,
                token
        );
    }
}
