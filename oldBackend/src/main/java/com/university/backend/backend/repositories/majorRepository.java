package com.university.backend.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.backend.backend.models.majorModel;

public interface majorRepository extends JpaRepository<majorModel, UUID>{
    majorModel findByName(String name);
}
