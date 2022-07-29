package com.sun.travels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrollment {
    @EmbeddedId
    private CourseEnrollmentKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("StudentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
}
