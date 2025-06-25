package com.university.backend.backend.mappers;

import org.springframework.stereotype.Component;

import com.university.backend.backend.dtos.majorDto;
import com.university.backend.backend.models.majorModel;

@Component
public class majorMapper {
    public majorDto toDto(majorModel entity){
        if(entity == null){return null;}
        return majorDto.builder()
                        .majorId(entity.getMajorId())
                        .name(entity.getName())
                        .build();
    }
    public majorModel toEntity(majorDto dto){
        if(dto == null){return null;}
        majorModel entity = new majorModel();
        entity.setMajorId(dto.getMajorId());
        entity.setName(dto.getName());
        return entity; 
    }
}
