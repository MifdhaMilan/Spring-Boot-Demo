package com.sun.travels.controller;


import com.sun.travels.model.CourseEnrollment;
import com.sun.travels.request.CourseEnrollmentRequest;
import com.sun.travels.service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course-enrollment")
public class CourseEnrollmentController {
    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @PostMapping("/create-course-enrollment")
    public ResponseEntity<CourseEnrollment> createCourseEnrollment(@RequestBody CourseEnrollmentRequest courseEnrollmentRequest){
        return courseEnrollmentService.createCourseEnrollment(courseEnrollmentRequest);
    }

}
