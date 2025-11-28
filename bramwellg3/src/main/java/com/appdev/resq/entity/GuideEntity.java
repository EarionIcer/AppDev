package com.appdev.resq.entity;

import java.time.LocalDateTime;

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
@Table(name = "guides")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guideID;

    private String guideName;
    private String description;
    private String category;
    private String steps;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}