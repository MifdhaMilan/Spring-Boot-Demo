package com.sun.travels.controller;

import com.sun.travels.model.Student;
import com.sun.travels.request.AddProfileToStudent;
import com.sun.travels.request.AddStudentToDepartment;
import com.sun.travels.request.StudentRequest;
import com.sun.travels.response.StudentResponse;
import com.sun.travels.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest){
       return studentService.createStudent(studentRequest);
    }
    @GetMapping("/get-student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getAllStudent(){
        return studentService.getAllStudent();
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/update-student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @PutMapping("/add-profile-to-student")
    public ResponseEntity<Student> addProfileToStudent(@RequestBody AddProfileToStudent addProfileToStudent){
        return studentService.addProfileToStudent(addProfileToStudent);
    }

    @PostMapping("/enroll-student-course")
    public ResponseEntity<Student> enrollStudentToCourse(@RequestBody Student student){
        return studentService.enrollStudentToCourse(student);
    }
}
