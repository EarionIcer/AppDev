package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.UserHotlineEntity;
import com.appdev.resq.repository.UserHotlineRepository;

@Service
public class UserHotlineService {
    
    @Autowired
    private UserHotlineRepository userHotlineRepository;

    public List<UserHotlineEntity> getAllUserHotlines() {
        return userHotlineRepository.findAll();
    }

    public Optional<UserHotlineEntity> getUserHotlineById(Long id) {
        return userHotlineRepository.findById(id);
    }

    public UserHotlineEntity saveUserHotline(UserHotlineEntity userHotline) {
        return userHotlineRepository.save(userHotline);
    }

    public void deleteUserHotline(Long id) {
        userHotlineRepository.deleteById(id);
    }
}