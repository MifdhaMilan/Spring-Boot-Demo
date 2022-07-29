package com.sun.travels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String duration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<CourseEnrollment> courseEnrollments;

}
