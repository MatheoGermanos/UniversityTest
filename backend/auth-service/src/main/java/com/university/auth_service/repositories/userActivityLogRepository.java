package com.university.auth_service.repositories;

import com.university.auth_service.models.userActivityLogModel;
import com.university.auth_service.models.userModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userActivityLogRepository extends JpaRepository<userActivityLogModel, UUID> {
    List<userActivityLogModel> findByUserId(userModel user);
    List<userActivityLogModel> findByIpAddress(String ipAddress);
    List<userActivityLogModel> findByAction(String action);
}