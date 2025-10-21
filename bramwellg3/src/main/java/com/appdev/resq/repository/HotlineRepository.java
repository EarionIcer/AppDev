package com.appdev.resq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appdev.resq.entity.HotlineEntity;

public interface HotlineRepository extends JpaRepository<HotlineEntity, Long> {
    // Add custom query methods if needed
}