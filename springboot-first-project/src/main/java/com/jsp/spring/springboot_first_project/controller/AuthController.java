package com.jsp.spring.springboot_first_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.springboot_first_project.entity.User;
import com.jsp.spring.springboot_first_project.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(
    origins = "http://localhost:5173",
    allowCredentials = "true"
)
public class AuthController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(
            @RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {

            return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                        "message",
                        "Email already registered"
                    ));
        }

        user.setPassword(
            passwordEncoder.encode(user.getPassword())
        );

        // Public signup is only for patients
        user.setRole(User.Role.PATIENT);

        userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of(
                    "message",
                    "Registration successful"
                ));
    }
}