package com.university.backend.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.backend.backend.dtos.studentDto;
import com.university.backend.backend.services.studentService;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/students")
public class studentController {

    @Autowired
    private studentService studentService;

    

    @GetMapping("/all")
    public List<studentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public ResponseEntity<studentDto> createStudent(@RequestBody studentDto student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<studentDto> updateStudent(@RequestBody studentDto student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }
    
    
}
