package com.university.auth_service.dtos;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ipChecklistDto {
    private UUID ipChecklistModelId;
    private int attemptAmount;
    private boolean isBanned;
    private String ipAddress;
    private LocalDateTime lastAttempt;
}
