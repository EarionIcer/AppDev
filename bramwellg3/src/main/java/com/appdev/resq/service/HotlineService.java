package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.HotlineEntity;
import com.appdev.resq.repository.HotlineRepository;

@Service
public class HotlineService {
    
    @Autowired
    private HotlineRepository hotlineRepository;

    public List<HotlineEntity> getAllHotlines() {
        return hotlineRepository.findAll();
    }

    public Optional<HotlineEntity> getHotlineById(Long id) {
        return hotlineRepository.findById(id);
    }

    public HotlineEntity saveHotline(HotlineEntity hotline) {
        return hotlineRepository.save(hotline);
    }

    public void deleteHotline(Long id) {
        hotlineRepository.deleteById(id);
    }
}