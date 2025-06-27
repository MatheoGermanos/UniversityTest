package com.university.auth_service.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String firstName;
    private String lastName;

    private Date dateOfBirth;

    private String gender;

    @ManyToMany
    @JoinTable(
        name = "userRoles",
        joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
        inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    )
    private Set<roleModel> roles;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 255)
    private String phoneNumber;

    private String userName;
    private String password;

    private boolean enabled;

    private LocalDateTime lastLogIn;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
