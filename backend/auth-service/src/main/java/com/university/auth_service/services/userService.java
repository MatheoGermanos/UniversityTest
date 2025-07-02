package com.university.auth_service.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.auth_service.dtos.roleDto;
import com.university.auth_service.dtos.userDto;
import com.university.auth_service.mappers.userMapper;
import com.university.auth_service.models.roleModel;
import com.university.auth_service.models.userModel;
import com.university.auth_service.repositories.roleRepository;
import com.university.auth_service.repositories.userRepository;

import jakarta.transaction.Transactional;

@Service
public class userService {
    
    @Autowired
    public userRepository userRepository;

    @Autowired
    public userMapper userMapper;

    @Autowired 
    public roleRepository roleRepository;

    public userDto getUserById(UUID id){
        return userRepository.findById(id)
                            .map(userMapper::toDto)
                            .orElse(null);
    }

    public List<userDto> getAllUsers(){
        return userRepository.findAll()
                            .stream()
                            .map(userMapper::toDto)
                            .toList();
    }

    public userDto getUserByEmail(String email){
        return userRepository.findByEmail(email)
                            .map(userMapper::toDto)
                            .orElse(null);
    }

    public userDto getUserByUserName(String userName){
        return userRepository.findByUsername(userName)
                            .map(userMapper::toDto)
                            .orElse(null);
    }

    public userDto createUser(userDto dto){
        if (userRepository.findByEmail(dto.getEmail()).isPresent() || userRepository.findByUsername(dto.getUserName()).isPresent()) {
            throw new RuntimeException("username or email already in use");
        }
        Set<roleModel> roles = new HashSet<>();
        if (dto.getRoleIds() != null) {
            roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
        }
        userModel entity = userMapper.toEntity(dto, roles);

        return userMapper.toDto(userRepository.save(entity));
    }

    @Transactional
    public userDto updateUser(userDto dto) {
        if (dto == null || dto.getUserId() == null) {
            throw new IllegalArgumentException("User or userId must not be null");
        }
        Optional<userModel> existing = userRepository.findById(dto.getUserId());
        if (existing.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Set<roleModel> roles = new HashSet<>();
        if (dto.getRoleIds() != null) {
            roles = new HashSet<>(roleRepository.findAllById(dto.getRoleIds()));
        }
        userModel entity = userMapper.toEntity(dto, roles);
        entity.setUpdatedAt(LocalDateTime.now());
        return userMapper.toDto(userRepository.save(entity));
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

}
