package com.appdev.resq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.resq.entity.EmergencyCardEntity;

public interface EmergencyCardRepository extends JpaRepository<EmergencyCardEntity, Long> {
    // Add custom query methods if needed
}