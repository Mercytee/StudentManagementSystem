package com.basics.studentmanagementsystem.service;

import com.basics.studentmanagementsystem.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface StudentService {

    ResponseEntity<Student> createStudent(Student student);
    ResponseEntity<Student> updateStudent(int id,Student student);
    ResponseEntity deleteStudent(int id );
    ResponseEntity getAllStudents( );



}
