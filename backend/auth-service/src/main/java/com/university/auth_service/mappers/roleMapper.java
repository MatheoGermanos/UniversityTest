package com.university.auth_service.mappers;

import org.springframework.stereotype.Component;

import com.university.auth_service.dtos.roleDto;
import com.university.auth_service.models.roleModel;

@Component
public class roleMapper {
    public roleDto toDto(roleModel entity){
        if(entity == null){return null;}
        return roleDto.builder()
                    .roleId(entity.getRoleId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .build();
    }
    public roleModel toEntity(roleDto dto){
        if(dto == null){return null;}
        return roleModel.builder()
                    .roleId(dto.getRoleId())
                    .name(dto.getName())
                    .description(dto.getDescription())
                    .createdAt(dto.getCreatedAt())
                    .updatedAt(dto.getUpdatedAt())
                    .build();
    }
}
