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

import com.appdev.resq.entity.UserHotlineEntity;
import com.appdev.resq.service.UserHotlineService;

@RestController
@RequestMapping("/api/user-hotlines")
public class UserHotlineController {
    
    @Autowired
    private UserHotlineService userHotlineService;

    @GetMapping
    public List<UserHotlineEntity> getAllUserHotlines() {
        return userHotlineService.getAllUserHotlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserHotlineEntity> getUserHotlineById(@PathVariable Long id) {
        Optional<UserHotlineEntity> userHotline = userHotlineService.getUserHotlineById(id);
        return userHotline.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserHotlineEntity createUserHotline(@RequestBody UserHotlineEntity userHotline) {
        return userHotlineService.saveUserHotline(userHotline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserHotlineEntity> updateUserHotline(@PathVariable Long id, 
                                                            @RequestBody UserHotlineEntity userHotline) {
        if (!userHotlineService.getUserHotlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userHotline.setUserID(id);
        return ResponseEntity.ok(userHotlineService.saveUserHotline(userHotline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserHotline(@PathVariable Long id) {
        if (!userHotlineService.getUserHotlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userHotlineService.deleteUserHotline(id);
        return ResponseEntity.ok().build();
    }
}