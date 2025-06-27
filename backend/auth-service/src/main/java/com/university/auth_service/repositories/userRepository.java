package com.university.auth_service.repositories;

import com.university.auth_service.models.userModel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userModel,UUID> {
    Optional<userModel> findByEmail(String email);
    Optional<userModel> findByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
}