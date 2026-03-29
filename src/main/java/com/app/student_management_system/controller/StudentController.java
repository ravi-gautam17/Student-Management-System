package com.app.student_management_system.controller;

import com.app.student_management_system.dto.StudentRequestDTO;
import com.app.student_management_system.dto.StudentResponseDTO;
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
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO dto){
        return studentService.saveStudent(dto);
    }

    // READ ALL
    @GetMapping
    public List<StudentResponseDTO> getAllStudent(){
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto){
        return studentService.updateStudent(id,dto);
    }
    //DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student details deleted successfully";
    }

    // SEARCH BY COURSE
    @GetMapping("/search")
    public List<StudentResponseDTO> getStudentsByCourse(@RequestParam String course){
        return studentService.getStudentByCourse(course);
    }
}
