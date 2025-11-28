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
@Table(name = "user_guides")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGuideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guideID;

    private Long userID;
    private String guide_name;
    private String steps;
    private Long hotlineID;
    private String category;
    private String description;
}