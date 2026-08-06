package com.java_learning.authentication_backend.controller;

import com.java_learning.authentication_backend.dto.CreateUserRequestDto;
import com.java_learning.authentication_backend.dto.CreateUserResponseDto;
import com.java_learning.authentication_backend.dto.UserLoginRequestDto;
import com.java_learning.authentication_backend.dto.UserLoginResponseDto;
import com.java_learning.authentication_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    // Add / Create User
    @PostMapping()
    public ResponseEntity<CreateUserResponseDto> createUse(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto response = userService.createUser(createUserRequestDto);
        return ResponseEntity.ok(response);
    }

    // Login User
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        UserLoginResponseDto response = userService.loginUser(userLoginRequestDto);
        return ResponseEntity.ok(response);
    }

}
