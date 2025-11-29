package com.appdev.resq.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "hotline_id")
    private HotlineEntity hotline;

    
    // Relationships
    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL)
    private List<UserGuideEntity> userGuides;
}