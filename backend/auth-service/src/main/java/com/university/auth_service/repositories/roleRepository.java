package com.university.auth_service.repositories;

import com.university.auth_service.models.roleModel;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepository extends JpaRepository<roleModel,UUID> {

    
}