package com.appdev.resq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.resq.entity.EmergencyCardEntity;
import com.appdev.resq.repository.EmergencyCardRepository;

@Service
public class EmergencyCardService {
    
    @Autowired
    private EmergencyCardRepository emergencyCardRepository;

    public List<EmergencyCardEntity> getAllEmergencyCards() {
        return emergencyCardRepository.findAll();
    }

    public Optional<EmergencyCardEntity> getEmergencyCardById(Long id) {
        return emergencyCardRepository.findById(id);
    }

    public EmergencyCardEntity saveEmergencyCard(EmergencyCardEntity emergencyCard) {
        return emergencyCardRepository.save(emergencyCard);
    }

    public void deleteEmergencyCard(Long id) {
        emergencyCardRepository.deleteById(id);
    }
}