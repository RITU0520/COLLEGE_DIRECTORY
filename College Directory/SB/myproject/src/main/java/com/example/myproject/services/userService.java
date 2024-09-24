package com.example.myproject.services;

import com.example.myproject.entities.user;
import com.example.myproject.repositories.usersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {

    private final usersRepository userRepository;

    public userService(usersRepository usersRepository) {
        this.userRepository = usersRepository;
    }

    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<user> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public user createUser(user user) {
        return userRepository.save(user);
    }

    public user updateUser(Long id, user userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword());
                    user.setEmail(userDetails.getEmail());
                    user.setPhonenumber(userDetails.getPhonenumber());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
