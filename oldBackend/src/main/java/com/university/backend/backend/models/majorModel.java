package com.university.backend.backend.models;

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
@Table(name = "majors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class majorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID majorId;

    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
