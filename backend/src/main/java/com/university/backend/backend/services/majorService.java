package com.university.backend.backend.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.backend.backend.dtos.majorDto;
import com.university.backend.backend.mappers.majorMapper;
import com.university.backend.backend.models.majorModel;
import com.university.backend.backend.repositories.majorRepository;

@Service
public class majorService {
    @Autowired
    private majorRepository majorRepository;

    @Autowired
    private majorMapper majorMapper;

    public List<majorDto> getAllMajors(){
        return majorRepository.findAll()
                            .stream()
                            .map(majorMapper::toDto)
                            .toList();
    }

    public majorDto addMajor(majorDto dto){
        majorModel major = majorMapper.toEntity(dto);
        major.setCreatedAt(LocalDateTime.now());
        return majorMapper.toDto(majorRepository.save(major));
    }

    public majorDto updateMajor(majorDto dto){
        Optional<majorModel> existing = majorRepository.findById(dto.getMajorId());
        if(existing.isEmpty()){
            throw new RuntimeException("Major not found");
        }
        majorModel major = majorMapper.toEntity(dto);
        major.setUpdatedAt(LocalDateTime.now());
        return majorMapper.toDto(majorRepository.save(major));
    }

    public void deleteMajor(UUID majorId){
        Optional<majorModel> existing = majorRepository.findById(majorId);
        if(existing.isEmpty()){
            throw new RuntimeException("Major not found");
        }
        majorRepository.deleteById(majorId);
    }

    public majorDto getMajorById(UUID majorId){
        return majorMapper.toDto(majorRepository.findById(majorId).get());
    }

    public majorDto getMajorByName(String name){
        return majorMapper.toDto(majorRepository.findByName(name));
    }

}
