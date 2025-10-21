package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.UserGuideEntity;
import com.appdev.resq.repository.UserGuideRepository;

@Service
public class UserGuideService {
    
    @Autowired
    private UserGuideRepository userGuideRepository;

    public List<UserGuideEntity> getAllUserGuides() {
        return userGuideRepository.findAll();
    }

    public Optional<UserGuideEntity> getUserGuideById(Long id) {
        return userGuideRepository.findById(id);
    }

    public UserGuideEntity saveUserGuide(UserGuideEntity userGuide) {
        return userGuideRepository.save(userGuide);
    }

    public void deleteUserGuide(Long id) {
        userGuideRepository.deleteById(id);
    }
}