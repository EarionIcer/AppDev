package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long userGuideID;

    private String favorite;

    @ManyToOne
    @JoinColumn(name = "userID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "guideID")
    private GuideEntity guide;
}