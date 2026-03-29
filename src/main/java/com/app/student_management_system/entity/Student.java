package com.app.student_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String course;

    @Column
    private int age;

    public Student(){
        //no args constructor
    }

    public Student(String name, String email,String course, int age) {
        this.name = name;
        this.email = email;
        this.course=course;
        this.age = age;
    }
}
