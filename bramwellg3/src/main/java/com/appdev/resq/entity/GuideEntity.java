package com.appdev.resq.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="guides")
public class GuideEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long guideID;

    private String guideName;
    private String description;
    private String category;
    private String steps;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public GuideEntity() {}

    public GuideEntity(Long guideID, String guideName, String description, 
                      String category, String steps, LocalDateTime created_at, LocalDateTime updated_at) {
        this.guideID = guideID;
        this.guideName = guideName;
        this.description = description;
        this.category = category;
        this.steps = steps;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getGuideID() {
        return guideID;
    }

    public void setGuideID(Long guideID) {
        this.guideID = guideID;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}