package com.university.auth_service.mappers;

import com.university.auth_service.dtos.userDto;
import com.university.auth_service.models.userModel;
import com.university.auth_service.models.roleModel;

import java.util.Set;
import java.util.stream.Collectors;

public class userMapper {
    public userDto toDto(userModel entity) {
        if (entity == null) { return null; }
        return userDto.builder()
                .userId(entity.getUserId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .roleIds(entity.getRoles() != null ? entity.getRoles().stream().map(roleModel::getRoleId).collect(Collectors.toSet()) : null)
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .userName(entity.getUserName())
                .enabled(entity.isEnabled())
                .lastLogIn(entity.getLastLogIn())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    // Note: toEntity expects a set of roleModel objects to be set elsewhere if needed
    public userModel toEntity(userDto dto, Set<roleModel> roles) {
        if (dto == null) { return null; }
        return userModel.builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dateOfBirth(dto.getDateOfBirth())
                .gender(dto.getGender())
                .roles(roles)
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .userName(dto.getUserName())
                .enabled(dto.isEnabled())
                .lastLogIn(dto.getLastLogIn())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
