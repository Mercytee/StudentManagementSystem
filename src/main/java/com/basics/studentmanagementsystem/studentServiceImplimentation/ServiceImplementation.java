package com.basics.studentmanagementsystem.studentServiceImplimentation;

import com.basics.studentmanagementsystem.model.Student;
import com.basics.studentmanagementsystem.repository.StudentRepository;
import com.basics.studentmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ServiceImplementation  implements StudentService {
    private final StudentRepository studentRepository;


    @Override
    public ResponseEntity<Student> createStudent(Student student) {
        Student student1 = new Student();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setIdentificationNumber(student.getIdentificationNumber());

        studentRepository.save(student1);
        return ResponseEntity.ok().body(student1);


    }

    @Override
    public ResponseEntity updateStudent(Long id) {
        Optional<Student>student = studentRepository.findById(id);
        if (student.isPresent()){
            Student student1 = student.get();
            student1.setFirstName(student1.getFirstName());
            student1.setLastName(student1.getLastName());
            student1.setIdentificationNumber(student1.getIdentificationNumber());

            studentRepository.save(student1);
            return ResponseEntity.ok().body("Student successfully updated");

        }else {return ResponseEntity.ok().body("Failed to update student");}

    }

    @Override
    public ResponseEntity deleteStudent(Long id) {
        Optional<Student>student = studentRepository.findById(id);
        if (student.isPresent()){


            studentRepository.delete(student.get());
            return ResponseEntity.ok().body("Student successfully deleted");

        }else {return ResponseEntity.ok().body("Failed to delete student");

    }

}

    @Override
    public ResponseEntity getAllStudents( ) {
        List<Student>studentList=studentRepository.findAll();
return ResponseEntity.ok().body(studentList);}
}
