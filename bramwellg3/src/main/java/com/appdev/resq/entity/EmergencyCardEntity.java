package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emergency_cards")
public class EmergencyCardEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cardID;
    
    private String contacts;
    private Long userID;
    private String status;

    public EmergencyCardEntity() {}

    public EmergencyCardEntity(Long cardID, String contacts, Long userID, String status) {
        this.cardID = cardID;
        this.contacts = contacts;
        this.userID = userID;
        this.status = status;
    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}