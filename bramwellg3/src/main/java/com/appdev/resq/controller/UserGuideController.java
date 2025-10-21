package com.appdev.resq.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdev.resq.entity.UserGuideEntity;
import com.appdev.resq.service.UserGuideService;

@RestController
@RequestMapping("/api/user-guides")
public class UserGuideController {
    
    @Autowired
    private UserGuideService userGuideService;

    @GetMapping
    public List<UserGuideEntity> getAllUserGuides() {
        return userGuideService.getAllUserGuides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGuideEntity> getUserGuideById(@PathVariable Long id) {
        Optional<UserGuideEntity> userGuide = userGuideService.getUserGuideById(id);
        return userGuide.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserGuideEntity createUserGuide(@RequestBody UserGuideEntity userGuide) {
        return userGuideService.saveUserGuide(userGuide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserGuideEntity> updateUserGuide(@PathVariable Long id, 
                                                         @RequestBody UserGuideEntity userGuide) {
        if (!userGuideService.getUserGuideById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userGuide.setGuideID(id);
        return ResponseEntity.ok(userGuideService.saveUserGuide(userGuide));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserGuide(@PathVariable Long id) {
        if (!userGuideService.getUserGuideById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userGuideService.deleteUserGuide(id);
        return ResponseEntity.ok().build();
    }
}