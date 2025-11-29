package com.appdev.resq.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotlineID;

    private String hotlineName;
    private String hotlineNumber;
    private String hotlineDesc;

    @OneToMany(mappedBy = "hotline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHotlineEntity> userHotlines;
}