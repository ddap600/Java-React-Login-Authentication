package com.java_learning.authentication_backend.controller;

import com.java_learning.authentication_backend.dto.*;
import com.java_learning.authentication_backend.entity.User;
import com.java_learning.authentication_backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    // Get all Users
    @GetMapping("/list-users")
    public ResponseEntity<List<UserDetailsResponseDto>> getAllUsers() {
        List<UserDetailsResponseDto> response = userService.getUsers();
        return ResponseEntity.ok(response);
    }


    // Add / Create User
    @PostMapping("/create-user")
    public ResponseEntity<CreateUserResponseDto> createUse(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto response = userService.createUser(createUserRequestDto);
        return ResponseEntity.ok(response);
    }


}
