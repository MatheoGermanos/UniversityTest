package com.university.auth_service.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "holds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class holdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID holdId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private userModel userId;

    private String reason;

    private boolean isActive;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
