package com.university.auth_service.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class roleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    private String name;

    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
