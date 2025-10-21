package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_guides")
public class UserGuideEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long guideID;

    private Long userID;
    private String guide_name;
    private String steps;
    private Long hotlineID;
    private String category;
    private String description;

    public UserGuideEntity() {}

    public UserGuideEntity(Long guideID, Long userID, String guide_name, String steps, 
                          Long hotlineID, String category, String description) {
        this.guideID = guideID;
        this.userID = userID;
        this.guide_name = guide_name;
        this.steps = steps;
        this.hotlineID = hotlineID;
        this.category = category;
        this.description = description;
    }

    public Long getGuideID() {
        return guideID;
    }

    public void setGuideID(Long guideID) {
        this.guideID = guideID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getGuide_name() {
        return guide_name;
    }

    public void setGuide_name(String guide_name) {
        this.guide_name = guide_name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Long getHotlineID() {
        return hotlineID;
    }

    public void setHotlineID(Long hotlineID) {
        this.hotlineID = hotlineID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}