package com.university.backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.backend.backend.StudentStatus;
import com.university.backend.backend.models.studentModel;
import java.util.List;
import java.util.UUID;


@Repository
public interface studentRepository extends JpaRepository<studentModel,UUID>{
    studentModel findByEmail(String email);
    List<studentModel> findByStatus(StudentStatus status);
}