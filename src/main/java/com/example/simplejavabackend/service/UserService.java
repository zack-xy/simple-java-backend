package com.example.simplejavabackend.service;

import com.example.simplejavabackend.entity.User;
import com.example.simplejavabackend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email) {
        if(userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User(username, email);
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserByUsername(String username) {
        if (username == null || username.isBlank()) {
            // 这里可以抛出 IllegalArgumentException，或直接返回 empty。
            // 我们这里返回 empty，保持方法签名不变。
            return Optional.empty();
        }

        // 交给 repository 完成查询，返回的就是 Optional<User>
        return userRepository.findByUsername(username);
    }
}
