package com.sun.travels.controller;

import com.sun.travels.model.Course;
import com.sun.travels.request.CourseRequest;
import com.sun.travels.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/create-course")
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest){
        return courseService.createCourse(courseRequest);
    }

    @GetMapping("/get-course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }
}
