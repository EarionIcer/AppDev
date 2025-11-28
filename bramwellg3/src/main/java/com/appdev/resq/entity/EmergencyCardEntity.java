package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emergency_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardID;
    
    private String contacts;
    private Long userID;
    private String status;
}