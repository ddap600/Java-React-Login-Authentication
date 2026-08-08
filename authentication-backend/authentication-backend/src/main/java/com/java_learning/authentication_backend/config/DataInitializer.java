package com.java_learning.authentication_backend.config;

import com.java_learning.authentication_backend.entity.Role;
import com.java_learning.authentication_backend.entity.User;
import com.java_learning.authentication_backend.repository.RoleRepository;
import com.java_learning.authentication_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedDatabase(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            if (roleRepository.count() == 0) {
                Role userRole = new Role("USER");
                Role adminRole = new Role("ADMIN");

                roleRepository.save(userRole);
                roleRepository.save(adminRole);
            }

            if (!userRepository.existsByUsername("admin")) {

                Role adminRole = roleRepository.findByName("ADMIN").get();

                User admin = new User();
                admin.setDisplayName("Regular Everyday Normal Admin");
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("password"));
                admin.getRoles().add(adminRole);

                userRepository.save(admin);

            }

            if (!userRepository.existsByUsername("user")) {

                Role userRole = roleRepository.findByName("USER").get();

                User user = new User();
                user.setDisplayName("Regular Everyday Normal User");
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("password"));
                user.getRoles().add(userRole);

                userRepository.save(user);

            }
        };
    }
}
