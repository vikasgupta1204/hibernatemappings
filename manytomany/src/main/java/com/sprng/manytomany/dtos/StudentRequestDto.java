package com.sprng.manytomany.dtos;

import com.sprng.manytomany.models.Course;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class StudentRequestDto {


    private  int id;
    private String firstName;

    private String lastName;

    private String email;

    private List<Course> courses;
}
