package com.java_learning.authentication_backend.controller;

import com.java_learning.authentication_backend.dto.UserLoginRequestDto;
import com.java_learning.authentication_backend.dto.UserLoginResponseDto;
import com.java_learning.authentication_backend.service.AuthService;
import com.java_learning.authentication_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Login User
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        UserLoginResponseDto response = authService.loginUser(userLoginRequestDto);
        return ResponseEntity.ok(response);
    }


}
