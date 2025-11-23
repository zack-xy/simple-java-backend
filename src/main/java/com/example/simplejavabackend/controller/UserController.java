package com.example.simplejavabackend.controller;

import com.example.simplejavabackend.entity.User;
import com.example.simplejavabackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/java-api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getEmail());
    }

    @GetMapping("/id/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username) {
        Optional<User> opt = userService.getUserByUsername(username);
        return ResponseEntity.of(opt);
    }
}
