package com.bank.service;

import com.bank.model.User;
import com.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ Create a new user
    public User createUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepository.save(user);
    }

    // ✅ Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Find user by username
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }

    public User registerUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepository.save(user);
    }
}