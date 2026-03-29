package com.app.student_management_system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequestDTO {
    private String name;
    private String email;
    private String course;
    private int age;
}

