package com.app.student_management_system.controller;

import com.app.student_management_system.entity.Student;
import com.app.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    // CREATE
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        return studentService.updateStudent(id,updatedStudent);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student details deleted successfully";
    }

    // SEARCH BY COURSE
    @GetMapping("/search")
    public List<Student> getStudentsByCourse(@RequestParam String course){
        return studentService.getStudentByCourse(course);
    }
}
