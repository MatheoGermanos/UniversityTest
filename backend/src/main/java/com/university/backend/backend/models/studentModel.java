package com.university.backend.backend.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import com.university.backend.backend.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class studentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 255)
    private String phoneNumber;
    private Integer enrolementYear;

    @ManyToOne
    @JoinColumn(name = "majorId")
    private majorModel majorId;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    private Float gpa;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
