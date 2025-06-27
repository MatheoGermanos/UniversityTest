package com.university.auth_service.repositories;

import com.university.auth_service.models.holdModel;
import com.university.auth_service.models.userModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface holdRepository extends JpaRepository<holdModel, UUID> {
    List<holdModel> findByUserId(userModel user);
    List<holdModel> findByIsActive(boolean isActive);
}