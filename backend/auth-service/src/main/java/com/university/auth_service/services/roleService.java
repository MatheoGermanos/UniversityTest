package com.university.auth_service.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.auth_service.dtos.roleDto;
import com.university.auth_service.mappers.roleMapper;
import com.university.auth_service.models.roleModel;
import com.university.auth_service.repositories.roleRepository;

import jakarta.transaction.Transactional;

@Service
public class roleService {
    @Autowired
    private roleRepository roleRepository;

    @Autowired
    private roleMapper roleMapper;

    public roleDto getRoleById(UUID id){
        return roleRepository.findById(id)
                            .map(roleMapper::toDto)
                            .orElse(null);
    }

    public List<roleDto> getRoles(){
        return roleRepository.findAll()
                            .stream()
                            .map(roleMapper::toDto)
                            .toList();
    }

    @Transactional
    public roleDto createRole(roleDto dto){
        if (roleRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Role with this name already exists");
        }
        roleModel entity = roleMapper.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());
        return roleMapper.toDto(roleRepository.save(entity));
    }

    @Transactional
    public roleDto updateRole(roleDto dto){
        Optional<roleModel> existing = roleRepository.findById(dto.getRoleId());
        if(existing.isEmpty()){
            throw new RuntimeException("Role not found");
        }
        roleModel entity = roleMapper.toEntity(dto);
        entity.setUpdatedAt(LocalDateTime.now());
        return roleMapper.toDto(roleRepository.save(entity));
    }

    public void deleteRole(UUID roleId){
        Optional<roleModel> existing = roleRepository.findById(roleId);
        if(existing.isEmpty()){
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(roleId);
    }

    public roleDto getRoleByName(String name){
        return roleMapper.toDto(roleRepository.findByName(name));
    }
}
