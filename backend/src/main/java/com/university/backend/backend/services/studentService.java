package com.university.backend.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.backend.backend.StudentStatus;
import com.university.backend.backend.dtos.studentDto;
import com.university.backend.backend.mappers.studentMapper;
import com.university.backend.backend.models.studentModel;
import com.university.backend.backend.repositories.studentRepository;


@Service
public class studentService {

    @Autowired
    private studentRepository studentRepository;


    @Autowired
    private studentMapper studentMapper;

    // @Autowired
    // private majorRepository majorRepository;

    public List<studentDto> getAllStudents(){
        return studentRepository.findAll().stream()
                                .map(studentMapper::toDto)
                                .toList();
    }

    public studentDto addStudent(studentDto dto) {
        studentModel student = studentMapper.toEntity(dto);
        student.setCreatedAt(LocalDateTime.now());

        return studentMapper.toDto(studentRepository.save(student));
    }

    public studentDto updateStudent(studentDto dto){
        Optional<studentModel> existing = studentRepository.findById(dto.getStudentId());
        if (existing.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        studentModel student = studentMapper.toEntity(dto);
        student.setUpdatedAt(LocalDateTime.now());
        return studentMapper.toDto(studentRepository.save(student));
    }

    public void deleteStudent(UUID studentId){
        Optional<studentModel> existing = studentRepository.findById(studentId);
        if (existing.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(studentId);
    }

    public studentDto getStudentByEmail(String email) {
        return studentMapper.toDto(studentRepository.findByEmail(email));
    }

    public List<studentDto> getStudentsByStatus(StudentStatus status) {
        return studentRepository.findByStatus(status).stream()
            .map(studentMapper::toDto)
            .toList();
    }
}
