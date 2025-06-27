package com.university.auth_service.repositories;

import com.university.auth_service.models.ipChecklistModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ipChecklistRepository extends JpaRepository<ipChecklistModel, UUID> {
    Optional<ipChecklistModel> findByIpAddress(String ipAddress);
}