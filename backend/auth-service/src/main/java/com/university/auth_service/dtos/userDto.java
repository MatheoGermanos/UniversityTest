package com.university.auth_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class userDto {
    private UUID userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private Set<UUID> roleIds;
    private String email;
    private String phoneNumber;
    private String userName;
    private boolean enabled;
    private LocalDateTime lastLogIn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
