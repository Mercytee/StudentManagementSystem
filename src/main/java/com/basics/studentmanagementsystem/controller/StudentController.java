package com.basics.studentmanagementsystem.controller;

import com.basics.studentmanagementsystem.model.Student;
import com.basics.studentmanagementsystem.service.StudentService;
import com.basics.studentmanagementsystem.validation.StudentValidations;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentValidations studentValidations;

    @GetMapping("/")
    @ApiOperation(value = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
    })
    public ResponseEntity getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adding a new student")
    public ResponseEntity<Object> createStudent(
            @ApiParam(value = "Last name of the student", required = true) @RequestParam @NotNull String lastName,
            @ApiParam(value = "First name of the student", required = true) @RequestParam @NotNull String firstName,
            @ApiParam(value = "National ID number of the student", required = true) @RequestParam String identificationNumber) {

        if (!StudentValidations.isLastNameValid(lastName)) {
            return ResponseEntity.badRequest().body("Last name must be letters only");
        }
        if (!StudentValidations.isFirstNameValid(firstName)) {
            return ResponseEntity.badRequest().body("first name must be letters only");
        }

        if (!StudentValidations.isIdValid(identificationNumber)) {
            return ResponseEntity.badRequest().body("Incorrect format. Identification Number follows this format xx-xxxxxxQxx");
        }

        Student student = new Student();
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setIdentificationNumber(identificationNumber);
        studentService.createStudent(student);

        return ResponseEntity.ok().body(student);

    }


    @PutMapping("/updatingStudent/{id}")
    @ApiOperation(value = "Updating student details")
    public ResponseEntity <Student>updateStudent(
            @ApiParam(value = "ID of the student to update", required = true)
            @PathVariable @NotNull int id,
            Student student){
        return studentService.updateStudent( id, student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    @ApiOperation(value = "Deleting student record")
    public ResponseEntity deleteStudent(
            @ApiParam(value = "ID of the student to delete", required = true)
            @PathVariable @NotNull int id) {
        return studentService.deleteStudent(id);
    }
}

