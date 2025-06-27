package com.university.auth_service.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userActivityLogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class userActivityLogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userActivityLogId;
    
    @ManyToOne
    private userModel userId;

    private String action;

    private String ipAddress;

    private LocalDateTime createdAt;
}