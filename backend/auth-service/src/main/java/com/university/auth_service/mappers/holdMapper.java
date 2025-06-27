package com.university.auth_service.mappers;

import org.springframework.stereotype.Component;

import com.university.auth_service.dtos.holdDto;
import com.university.auth_service.models.holdModel;
import com.university.auth_service.models.holdModel.holdModelBuilder;
import com.university.auth_service.models.userModel;

@Component
public class holdMapper {
    public holdDto toDto(holdModel entity) {
        if (entity == null) { return null; }
        return holdDto.builder()
                .holdId(entity.getHoldId())
                .userId(entity.getUserId() != null ? entity.getUserId().getUserId() : null)
                .reason(entity.getReason())
                .isActive(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public holdModel toEntity(holdDto dto) {
        if (dto == null) { return null; }
        holdModelBuilder builder = holdModel.builder()
            .holdId(dto.getHoldId())
            .reason(dto.getReason())
            .isActive(dto.isActive())
            .createdAt(dto.getCreatedAt())
            .updatedAt(dto.getUpdatedAt());

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
