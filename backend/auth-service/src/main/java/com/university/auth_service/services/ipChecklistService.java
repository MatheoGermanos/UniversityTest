package com.university.auth_service.services;

import com.university.auth_service.dtos.ipChecklistDto;
import com.university.auth_service.mappers.ipChecklistMapper;
import com.university.auth_service.models.ipChecklistModel;
import com.university.auth_service.repositories.ipChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ipChecklistService {
    @Autowired
    private ipChecklistRepository ipChecklistRepository;
    @Autowired
    private ipChecklistMapper ipChecklistMapper;

    public List<ipChecklistDto> getAll() {
        return ipChecklistRepository.findAll().stream()
                .map(ipChecklistMapper::toDto)
                .toList();
    }

    public Optional<ipChecklistDto> getById(UUID id) {
        return ipChecklistRepository.findById(id)
                .map(ipChecklistMapper::toDto);
    }

    public Optional<ipChecklistDto> getByIpAddress(String ipAddress) {
        return ipChecklistRepository.findByIpAddress(ipAddress)
                .map(ipChecklistMapper::toDto);
    }

    public ipChecklistDto create(ipChecklistDto dto) {
        ipChecklistModel entity = ipChecklistMapper.toEntity(dto);
        return ipChecklistMapper.toDto(ipChecklistRepository.save(entity));
    }

    public ipChecklistDto update(ipChecklistDto dto) {
        if (dto == null || dto.getIpChecklistModelId() == null) {
            throw new IllegalArgumentException("DTO or ID must not be null");
        }
        Optional<ipChecklistModel> optional = ipChecklistRepository.findById(dto.getIpChecklistModelId());
        if (optional.isEmpty()) {
            throw new RuntimeException("IP Checklist entry not found");
        }
        ipChecklistModel entity = ipChecklistMapper.toEntity(dto);
        // Optionally preserve fields not present in the DTO
        entity.setIpChecklistModelId(optional.get().getIpChecklistModelId());
        return ipChecklistMapper.toDto(ipChecklistRepository.save(entity));
    }

    public void delete(UUID id) {
        ipChecklistRepository.deleteById(id);
    }
}
