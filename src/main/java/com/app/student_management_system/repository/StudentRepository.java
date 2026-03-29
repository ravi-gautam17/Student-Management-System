package com.app.student_management_system.repository;

import java.util.*;

import com.app.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // custom query methods

    // find students by course
    public List<Student> findByCourse(String course);

    // find students by name containing keyword
    public List<Student> findByNameContaining(String keyword);

}
