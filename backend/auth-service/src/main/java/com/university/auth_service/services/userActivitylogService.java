package com.university.auth_service.services;

import com.university.auth_service.dtos.userActivityLogDto;
import com.university.auth_service.mappers.userActivityLogMapper;
import com.university.auth_service.models.userActivityLogModel;
import com.university.auth_service.repositories.userActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class userActivitylogService {
    @Autowired
    private userActivityLogRepository userActivityLogRepository;
    @Autowired
    private userActivityLogMapper userActivityLogMapper;

    public List<userActivityLogDto> getAllUserActivityLog() {
        return userActivityLogRepository.findAll()
                                        .stream()
                                        .map(userActivityLogMapper::toDto)
                                        .toList();
    }

    public Optional<userActivityLogDto> getUserActivityLogById(UUID id) {
        return userActivityLogRepository.findById(id)
                .map(userActivityLogMapper::toDto);
    }

    public userActivityLogDto createUserActivityLog(userActivityLogDto dto) {
        userActivityLogModel entity = userActivityLogMapper.toEntity(dto);
        return userActivityLogMapper.toDto(userActivityLogRepository.save(entity));
    }

    public userActivityLogDto updateUserActivityLog(userActivityLogDto dto) {
        if (dto == null || dto.getUserActivityLogId() == null) {
            throw new IllegalArgumentException("DTO or ID must not be null");
        }
        Optional<userActivityLogModel> optional = userActivityLogRepository.findById(dto.getUserActivityLogId());
        if (optional.isEmpty()) {
            throw new RuntimeException("User activity log entry not found");
        }
        userActivityLogModel entity = userActivityLogMapper.toEntity(dto);
        return userActivityLogMapper.toDto(userActivityLogRepository.save(entity));
    }

    public void deleteUserActivityLog(UUID id) {
        userActivityLogRepository.deleteById(id);
    }
}
