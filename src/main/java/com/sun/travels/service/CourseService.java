package com.sun.travels.service;

import com.sun.travels.model.Course;
import com.sun.travels.repository.CourseRepository;
import com.sun.travels.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<Course> createCourse(CourseRequest courseRequest){
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDuration(courseRequest.getDuration());
        return ResponseEntity.ok(courseRepository.save(course));
    }

    public ResponseEntity<Course> getCourse(int id){
        return ResponseEntity.ok(courseRepository.findById(id).orElse(null));
    }


}
