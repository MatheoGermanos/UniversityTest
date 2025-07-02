package com.university.auth_service.services;

import com.university.auth_service.dtos.holdDto;
import com.university.auth_service.mappers.holdMapper;
import com.university.auth_service.models.holdModel;
import com.university.auth_service.repositories.holdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class holdService {
    @Autowired
    private holdRepository holdRepository;
    @Autowired
    private holdMapper holdMapper;

    public List<holdDto> getAllHolds() {
        return holdRepository.findAll()
                            .stream()
                            .map(holdMapper::toDto)
                            .toList();
    }

    public Optional<holdDto> getHoldById(UUID id) {
        return holdRepository.findById(id)
                .map(holdMapper::toDto);
    }

    public holdDto createHold(holdDto dto) {
        holdModel entity = holdMapper.toEntity(dto);
        return holdMapper.toDto(holdRepository.save(entity));
    }

    public holdDto updateHold(holdDto dto) {
        if (dto == null || dto.getHoldId() == null) {
            throw new IllegalArgumentException("DTO or ID must not be null");
        }
        Optional<holdModel> optional = holdRepository.findById(dto.getHoldId());
        if (optional.isEmpty()) {
            throw new RuntimeException("Hold entry not found");
        }
        holdModel entity = holdMapper.toEntity(dto);
        return holdMapper.toDto(holdRepository.save(entity));
    }

    public void deleteHold(UUID id) {
        holdRepository.deleteById(id);
    }
}
