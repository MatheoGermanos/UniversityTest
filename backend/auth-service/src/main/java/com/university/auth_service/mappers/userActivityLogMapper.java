package com.university.auth_service.mappers;

import org.springframework.stereotype.Component;

import com.university.auth_service.dtos.userActivityLogDto;
import com.university.auth_service.models.userActivityLogModel;
import com.university.auth_service.models.userModel;

@Component
public class userActivityLogMapper {
    public userActivityLogDto toDto(userActivityLogModel entity) {
        if (entity == null) { return null; }
        return userActivityLogDto.builder()
                .userActivityLogId(entity.getUserActivityLogId())
                .userId(entity.getUserId() != null ? entity.getUserId().getUserId() : null)
                .action(entity.getAction())
                .ipAddress(entity.getIpAddress())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // Reference by ID pattern: only set userId if present
    public userActivityLogModel toEntity(userActivityLogDto dto) {
        if (dto == null) { return null; }
        userActivityLogModel.userActivityLogModelBuilder builder = userActivityLogModel.builder()
                .userActivityLogId(dto.getUserActivityLogId())
                .action(dto.getAction())
                .ipAddress(dto.getIpAddress())
                .createdAt(dto.getCreatedAt());
        if (dto.getUserId() != null) {
            userModel user = new userModel();
            user.setUserId(dto.getUserId());
            builder.userId(user);
        } else {
            builder.userId(null);
        }
        return builder.build();
    }
}
