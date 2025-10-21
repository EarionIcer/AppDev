package com.appdev.resq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.resq.entity.GuideEntity;

public interface GuideRepository extends JpaRepository<GuideEntity, Long> {
    // Add custom query methods if needed
}