package com.sun.travels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    private int id;
    private String qualification;
    private String gpa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profile")
    @JsonIgnore
    private Student student;


}
