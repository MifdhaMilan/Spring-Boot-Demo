package com.sun.travels.request;

import com.sun.travels.model.Course;
import com.sun.travels.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrollmentRequest {
    private int studentId;
    private int courseId;
}
