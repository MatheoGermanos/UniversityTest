package com.university.backend.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.backend.backend.dtos.majorDto;
import com.university.backend.backend.services.majorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/api/majors")
public class majorController {
    @Autowired
    private majorService majorService;

    @GetMapping("/all")
    public List<majorDto> getAllMajors() {
        return majorService.getAllMajors();
    }

    @PostMapping("/create")
    public ResponseEntity<majorDto> createMajor(@RequestBody majorDto major) {
        
        return ResponseEntity.ok(majorService.addMajor(major));
    }
    
    @DeleteMapping("/delete/{majorId}")
    public ResponseEntity<String> deleteMajor(@PathVariable UUID majorId){
        majorService.deleteMajor(majorId);
        return ResponseEntity.ok("Major deleted succesfully");
    }

    @PutMapping("/update")
    public ResponseEntity<majorDto> updateMajor(@RequestBody majorDto major) {
        return ResponseEntity.ok(majorService.updateMajor(major));
    }
    
}
