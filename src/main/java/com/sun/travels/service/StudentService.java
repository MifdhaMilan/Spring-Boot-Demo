package com.sun.travels.service;

import com.sun.travels.model.Profile;
import com.sun.travels.model.Student;
import com.sun.travels.repository.ProfileRepository;
import com.sun.travels.repository.StudentRepository;
import com.sun.travels.request.AddProfileToStudent;
import com.sun.travels.request.StudentRequest;
import com.sun.travels.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfileRepository profileRepository;
    public ResponseEntity<StudentResponse> createStudent(StudentRequest studentRequest){
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setContactNo(studentRequest.getContactNo());
        student.setProfile(studentRequest.getProfile());
        StudentResponse studentResponse = new StudentResponse();
        studentRepository.save(student);
        studentResponse.setStudent(student);
        studentResponse.setMessage("student added successfully");
        return ResponseEntity.ok(studentResponse);
    }
    public ResponseEntity<Student> getStudentById(int id){
        return ResponseEntity.ok(studentRepository.findById(id).orElse(null));
    }

    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentRepository.findAll());
    }

    public ResponseEntity<Student> deleteStudentById(int id){
        Student deletedStudent = getStudentById(id).getBody();
        try{
            studentRepository.deleteById(id);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok(deletedStudent);
    }

    public ResponseEntity<Student> updateStudent(Student student){
        Student existingStudent = getStudentById(student.getId()).getBody();
        try{
            existingStudent.setId(student.getId());
            existingStudent.setName(student.getName());
            existingStudent.setContactNo(student.getContactNo());
            existingStudent.setProfile(student.getProfile());
            existingStudent.setDepartment(student.getDepartment());
            studentRepository.save(existingStudent);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok(existingStudent);
    }

    public ResponseEntity<Student> addProfileToStudent(AddProfileToStudent addProfileToStudent){
        Student student = getStudentById(addProfileToStudent.getStudentId()).getBody();
        Profile profile = profileRepository.findById(addProfileToStudent.getProfileId()).orElse(null);
        student.setProfile(profile);
        return ResponseEntity.ok(studentRepository.save(student));
    }

    public ResponseEntity<Student> enrollStudentToCourse(Student student){
        return ResponseEntity.ok(studentRepository.save(student));

    }

}
