package com.sun.travels.service;

import com.sun.travels.model.CourseEnrollment;
import com.sun.travels.repository.CourseEnrollmentRepository;
import com.sun.travels.repository.CourseRepository;
import com.sun.travels.repository.StudentRepository;
import com.sun.travels.request.CourseEnrollmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrollmentService {
    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<CourseEnrollment> createCourseEnrollment(CourseEnrollmentRequest courseEnrollmentRequest){
        CourseEnrollment courseEnrollment = new CourseEnrollment();
        try{
            courseEnrollment.setCourse(courseRepository.findById(courseEnrollmentRequest.getCourseId()).orElse(null));
            courseEnrollment.setStudent(studentRepository.findById(courseEnrollmentRequest.getStudentId()).orElse(null));
            courseEnrollmentRepository.save(courseEnrollment);
        }catch(Exception e){
            System.out.println(e);
        }
        return ResponseEntity.ok(courseEnrollment);

    }
}
