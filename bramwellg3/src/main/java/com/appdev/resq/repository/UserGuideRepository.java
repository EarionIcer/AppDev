package com.appdev.resq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.resq.entity.UserGuideEntity;

public interface UserGuideRepository extends JpaRepository<UserGuideEntity, Long> {
    // Add custom query methods if needed
}