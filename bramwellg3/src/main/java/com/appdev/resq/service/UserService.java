package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.UserEntity;
import com.appdev.resq.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Create new user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Update existing user
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFName(userDetails.getFName());
                    user.setLName(userDetails.getLName());
                    user.setBirthdate(userDetails.getBirthdate());
                    user.setEmail(userDetails.getEmail());
                    user.setAllergies(userDetails.getAllergies());
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword());
                    user.setPhoneNumber(userDetails.getPhoneNumber());
                    user.setAddress(userDetails.getAddress());
                    user.setBloodType(userDetails.getBloodType());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
