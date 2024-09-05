package com.olympic.olydash.service;

import com.olympic.olydash.repository.UserDAO;
import com.olympic.olydash.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String signUp(User user) {
        Optional<User> existingUser = userDAO.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Email already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
        return "User registered successfully";
    }

    public String login(String email, String password) {
        Optional<User> userOptional = userDAO.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful";
            } else {
                return "Incorrect password";
            }
        } else {
            return "User not registered";
        }
    }
}
