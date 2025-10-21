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

import com.appdev.resq.entity.GuideEntity;
import com.appdev.resq.service.GuideService;

@RestController
@RequestMapping("/api/guides")
public class GuideController {
    
    @Autowired
    private GuideService guideService;

    @GetMapping
    public List<GuideEntity> getAllGuides() {
        return guideService.getAllGuides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideEntity> getGuideById(@PathVariable Long id) {
        Optional<GuideEntity> guide = guideService.getGuideById(id);
        return guide.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GuideEntity createGuide(@RequestBody GuideEntity guide) {
        return guideService.saveGuide(guide);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideEntity> updateGuide(@PathVariable Long id, 
                                                @RequestBody GuideEntity guide) {
        if (!guideService.getGuideById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        guide.setGuideID(id);
        return ResponseEntity.ok(guideService.saveGuide(guide));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable Long id) {
        if (!guideService.getGuideById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        guideService.deleteGuide(id);
        return ResponseEntity.ok().build();
    }
}