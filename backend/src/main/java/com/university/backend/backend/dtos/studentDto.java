package com.university.backend.backend.dtos;

import java.sql.Date;
import java.util.UUID;

import com.university.backend.backend.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class studentDto {
    private UUID studentId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private Integer enrolementYear;
    private UUID majorId;
    private StudentStatus status;
    private Float gpa;
}
