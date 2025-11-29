package com.appdev.resq.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_hotlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserHotlineEntity {
    @Id
    private Long userID;
    private Long hotlineID;
    private String quickDialStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "hotline_id")
    private HotlineEntity hotline;
}