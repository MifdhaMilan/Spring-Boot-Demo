package com.sun.travels.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseEnrollmentKey implements Serializable {
    @Column(name = "student_id")
    private int StudentId;
    @Column(name = "course_id")
    private int courseId;
}
