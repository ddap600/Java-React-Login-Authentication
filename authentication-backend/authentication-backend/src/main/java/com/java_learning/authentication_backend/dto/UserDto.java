package com.java_learning.authentication_backend.dto;

import com.java_learning.authentication_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String displayName;
    private String userName;
    private String password;
    private Set<Role> roles;
}
