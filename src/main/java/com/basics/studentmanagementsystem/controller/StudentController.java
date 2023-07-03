package com.basics.studentmanagementsystem.controller;

import com.basics.studentmanagementsystem.model.Student;
import com.basics.studentmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity getAllStudents( ){
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    public ResponseEntity createStudent(Student student){
        return studentService.createStudent(student);
    }
    @PutMapping("/updatingStudent/{id}")
    public ResponseEntity updateStudent (@PathVariable Long id, Student student){
        return studentService.updateStudent(id);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent (@PathVariable Long id){
        return studentService.deleteStudent(id);

    }
}
