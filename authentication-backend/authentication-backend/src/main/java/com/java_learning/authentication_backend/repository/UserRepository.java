package com.java_learning.authentication_backend.repository;

import com.java_learning.authentication_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
