package com.app.student_management_system.service;

import com.app.student_management_system.dto.StudentRequestDTO;
import com.app.student_management_system.dto.StudentResponseDTO;
import com.app.student_management_system.entity.Student;
import com.app.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // map dto to entity
    private Student mapToEntity(StudentRequestDTO dto){
        Student student=new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        student.setAge(dto.getAge());
        return student;
    }

    // map entity to dto
   private StudentResponseDTO mapToDTO(Student student){
        return new StudentResponseDTO(student.getId(), student.getName(),student.getEmail(),student.getCourse(), student.getAge());

   }

    // create or save a student
     public StudentResponseDTO saveStudent(StudentRequestDTO dto){
        Student student=mapToEntity(dto);
        Student savedStudent=studentRepository.save(student);
        return mapToDTO(savedStudent);
     }
    // get all students
    public List<StudentResponseDTO> getAllStudents(){
         List<Student> allStudent= studentRepository.findAll();
         List<StudentResponseDTO> listResponseDTO=new ArrayList<>();
         for(Student std:allStudent){
             listResponseDTO.add(mapToDTO(std));
         }
         return listResponseDTO;
    }
    // get student by ID
    public StudentResponseDTO getStudentById(Long id){
       Student student= studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found by "+id));
       return mapToDTO(student);
    }
    // update student
     public StudentResponseDTO updateStudent(Long id,StudentRequestDTO dto){
        Student existing=studentRepository.findById(id).orElseThrow(() ->new RuntimeException("Student not found with "+id));
        existing.setCourse(dto.getCourse());
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setAge(dto.getAge());
        Student stud=studentRepository.save(existing);
        return mapToDTO(stud);

     }
    // delete student
    public void deleteStudent(Long id){
         Student toBeDeletedStudent=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find element with Id "+id));
         studentRepository.delete(toBeDeletedStudent);
    }

    // find by course
    public List<StudentResponseDTO> getStudentByCourse(String course){
         List<Student> studentList=studentRepository.findByCourse(course);
         return studentList.stream().map(this::mapToDTO).toList();
    }

}
