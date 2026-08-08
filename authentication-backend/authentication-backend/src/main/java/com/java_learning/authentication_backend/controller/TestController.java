package com.java_learning.authentication_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {


    /*
    Test Token

    Meant to test the use of a token for user authentication
    This request should only work if a token is used
     */
    @GetMapping("/login-authentication-test")
    public ResponseEntity<String> testToken(Authentication authentication) {
        return ResponseEntity.ok("User: " + authentication.getName());
    }

    /*
    Test Admin

    Meant to test the use of role based authentication
    This request should only work if a token is used and it belongs to a user with admin role
     */
    @GetMapping("/login-admin-test")
    public ResponseEntity<String> testAdmin(Authentication authentication) {
        return ResponseEntity.ok("User: " + authentication.getName() + " Roles: " + authentication.getAuthorities());
    }
}
