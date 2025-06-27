package com.university.auth_service.mappers;

import org.springframework.stereotype.Component;

import com.university.auth_service.dtos.ipChecklistDto;
import com.university.auth_service.models.ipChecklistModel;

@Component
public class ipChecklistMapper {
    public ipChecklistDto toDto(ipChecklistModel entity) {
        if (entity == null) { return null; }
        return ipChecklistDto.builder()
                .ipChecklistModelId(entity.getIpChecklistModelId())
                .attemptAmount(entity.getAttemptAmount())
                .isBanned(entity.isBanned())
                .ipAddress(entity.getIpAddress())
                .lastAttempt(entity.getLastAttempt())
                .build();
    }

    public ipChecklistModel toEntity(ipChecklistDto dto) {
        if (dto == null) { return null; }
        return ipChecklistModel.builder()
                .ipChecklistModelId(dto.getIpChecklistModelId())
                .attemptAmount(dto.getAttemptAmount())
                .isBanned(dto.isBanned())
                .ipAddress(dto.getIpAddress())
                .lastAttempt(dto.getLastAttempt())
                .build();
    }
}
