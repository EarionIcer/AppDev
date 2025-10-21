package com.appdev.resq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.resq.entity.UserHotlineEntity;

public interface UserHotlineRepository extends JpaRepository<UserHotlineEntity, Long> {
    // Add custom query methods if needed
}