package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_hotlines")
public class UserHotlineEntity {
    @Id
    private Long userID;
    private Long hotlineID;
    private String quickDialStatus;

    public UserHotlineEntity() {}

    public UserHotlineEntity(Long userID, Long hotlineID, String quickDialStatus) {
        this.userID = userID;
        this.hotlineID = hotlineID;
        this.quickDialStatus = quickDialStatus;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getHotlineID() {
        return hotlineID;
    }

    public void setHotlineID(Long hotlineID) {
        this.hotlineID = hotlineID;
    }

    public String getQuickDialStatus() {
        return quickDialStatus;
    }

    public void setQuickDialStatus(String quickDialStatus) {
        this.quickDialStatus = quickDialStatus;
    }
}