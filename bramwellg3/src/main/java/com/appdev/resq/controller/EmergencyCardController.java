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

import com.appdev.resq.entity.EmergencyCardEntity;
import com.appdev.resq.service.EmergencyCardService;

@RestController
@RequestMapping("/api/emergency-cards")
public class EmergencyCardController {
    
    @Autowired
    private EmergencyCardService emergencyCardService;

    @GetMapping
    public List<EmergencyCardEntity> getAllEmergencyCards() {
        return emergencyCardService.getAllEmergencyCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyCardEntity> getEmergencyCardById(@PathVariable Long id) {
        Optional<EmergencyCardEntity> emergencyCard = emergencyCardService.getEmergencyCardById(id);
        return emergencyCard.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmergencyCardEntity createEmergencyCard(@RequestBody EmergencyCardEntity emergencyCard) {
        return emergencyCardService.saveEmergencyCard(emergencyCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyCardEntity> updateEmergencyCard(@PathVariable Long id, 
                                                                 @RequestBody EmergencyCardEntity emergencyCard) {
        if (!emergencyCardService.getEmergencyCardById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        emergencyCard.setCardID(id);
        return ResponseEntity.ok(emergencyCardService.saveEmergencyCard(emergencyCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyCard(@PathVariable Long id) {
        if (!emergencyCardService.getEmergencyCardById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        emergencyCardService.deleteEmergencyCard(id);
        return ResponseEntity.ok().build();
    }
}