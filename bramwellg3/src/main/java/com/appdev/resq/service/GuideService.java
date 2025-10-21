package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.GuideEntity;
import com.appdev.resq.repository.GuideRepository;

@Service
public class GuideService {
    
    @Autowired
    private GuideRepository guideRepository;

    public List<GuideEntity> getAllGuides() {
        return guideRepository.findAll();
    }

    public Optional<GuideEntity> getGuideById(Long id) {
        return guideRepository.findById(id);
    }

    public GuideEntity saveGuide(GuideEntity guide) {
        return guideRepository.save(guide);
    }

    public void deleteGuide(Long id) {
        guideRepository.deleteById(id);
    }
}