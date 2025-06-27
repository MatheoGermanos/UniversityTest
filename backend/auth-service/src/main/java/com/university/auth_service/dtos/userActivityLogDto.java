package com.university.auth_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class userActivityLogDto {
    private UUID userActivityLogId;
    private UUID userId;
    private String action;
    private String ipAddress;
    private LocalDateTime createdAt;
}
