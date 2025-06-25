package com.university.backend.backend.mappers;

import org.springframework.stereotype.Component;

import com.university.backend.backend.models.majorModel;
import com.university.backend.backend.models.studentModel;
import com.university.backend.backend.dtos.studentDto;

@Component
public class studentMapper {
    public studentDto toDto(studentModel entity) {
        if (entity == null) return null;
        return studentDto.builder()
            .studentId(entity.getStudentId())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName())
            .dateOfBirth(entity.getDateOfBirth())
            .gender(entity.getGender())
            .email(entity.getEmail())
            .phoneNumber(entity.getPhoneNumber())
            .enrolementYear(entity.getEnrolementYear())
            // .majorId(entity.getMajorId() != null 
            //     ? com.university.backend.backend.dtos.majorDto.builder()
            //         .majorId(entity.getMajorId().getMajorId())
            //         .name(entity.getMajorId().getName())
            //         .build()
            //     : null)
            .majorId(entity.getMajorId() != null ? entity.getMajorId().getMajorId() : null)

            .status(entity.getStatus())
            .gpa(entity.getGpa())
            .build();
    }

    public studentModel toEntity(studentDto dto) {
        if (dto == null) return null;
        studentModel entity = new studentModel();
        entity.setStudentId(dto.getStudentId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEnrolementYear(dto.getEnrolementYear());
        // Only set majorModel if majorId is present
        if (dto.getMajorId() != null) {
            majorModel major = new majorModel();
            major.setMajorId(dto.getMajorId());
            entity.setMajorId(major);
        } else {
            entity.setMajorId(null);
        }
        entity.setStatus(dto.getStatus());
        entity.setGpa(dto.getGpa());
        return entity;
    }
}