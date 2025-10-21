package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotlines")
public class HotlineEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long hotlineID;

    private String hotlineName;
    private String hotlineNumber;
    private String hotlineDesc;

    public HotlineEntity() {}

    public HotlineEntity(Long hotlineID, String hotlineName, String hotlineNumber, String hotlineDesc) {
        this.hotlineID = hotlineID;
        this.hotlineName = hotlineName;
        this.hotlineNumber = hotlineNumber;
        this.hotlineDesc = hotlineDesc;
    }

    public Long getHotlineID() {
        return hotlineID;
    }

    public void setHotlineID(Long hotlineID) {
        this.hotlineID = hotlineID;
    }

    public String getHotlineName() {
        return hotlineName;
    }

    public void setHotlineName(String hotlineName) {
        this.hotlineName = hotlineName;
    }

    public String getHotlineNumber() {
        return hotlineNumber;
    }

    public void setHotlineNumber(String hotlineNumber) {
        this.hotlineNumber = hotlineNumber;
    }

    public String getHotlineDesc() {
        return hotlineDesc;
    }

    public void setHotlineDesc(String hotlineDesc) {
        this.hotlineDesc = hotlineDesc;
    }
}