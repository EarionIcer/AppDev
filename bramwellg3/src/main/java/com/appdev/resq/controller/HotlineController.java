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

import com.appdev.resq.entity.HotlineEntity;
import com.appdev.resq.service.HotlineService;

@RestController
@RequestMapping("/api/hotlines")
public class HotlineController {
    
    @Autowired
    private HotlineService hotlineService;

    @GetMapping
    public List<HotlineEntity> getAllHotlines() {
        return hotlineService.getAllHotlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotlineEntity> getHotlineById(@PathVariable Long id) {
        Optional<HotlineEntity> hotline = hotlineService.getHotlineById(id);
        return hotline.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HotlineEntity createHotline(@RequestBody HotlineEntity hotline) {
        return hotlineService.saveHotline(hotline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotlineEntity> updateHotline(@PathVariable Long id, 
                                                     @RequestBody HotlineEntity hotline) {
        if (!hotlineService.getHotlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hotline.setHotlineID(id);
        return ResponseEntity.ok(hotlineService.saveHotline(hotline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotline(@PathVariable Long id) {
        if (!hotlineService.getHotlineById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        hotlineService.deleteHotline(id);
        return ResponseEntity.ok().build();
    }
}