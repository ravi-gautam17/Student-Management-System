package com.app.student_management_system.service;

import com.app.student_management_system.entity.Student;
import com.app.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // create or save a student
     public Student saveStudent(Student student){
          return studentRepository.save(student);
     }
    // get all students
    public List<Student> getAllStudents(){
         return studentRepository.findAll();
    }
    // get student by ID
    public Student getStudentById(Long id){
         Optional<Student> student= studentRepository.findById(id);
         if(student.isPresent()){
             return student.get();
         }
         else{
             throw new RuntimeException("Student not found with id "+id);
         }
    }
    // update student
     public Student updateStudent(Long id,Student updatedStudent){
         Student existing=getStudentById(id);

         // Update the student fields
         existing.setAge(updatedStudent.getAge());
         existing.setEmail(updatedStudent.getEmail());
         existing.setCourse(updatedStudent.getCourse());
         existing.setName(updatedStudent.getName());
         return studentRepository.save(existing);
     }
    // delete student
    public void deleteStudent(Long id){
         studentRepository.deleteById(id);
    }

    // find by course
    public List<Student> getStudentByCourse(String course){
         return studentRepository.findByCourse(course);
    }
}
