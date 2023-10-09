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
    public ResponseEntity updateStudent(int id,Student updatedStudent) {
        Optional<Student>student = studentRepository.findById(id);
        if (student.isPresent()){
            Student student1 = student.get();
            student1.setId(id);
            student1.setFirstName(updatedStudent.getFirstName());
            student1.setLastName(updatedStudent.getLastName());
            student1.setIdentificationNumber(updatedStudent.getIdentificationNumber());
            try{
                studentRepository.save(student1);

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntity.ok().body("Error in updating student.");

            }
            return ResponseEntity.ok().body("Student successfully updated");

        }
        return ResponseEntity.ok().body("Student is not found.");

    }

    @Override
    public ResponseEntity deleteStudent(int id) {
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
