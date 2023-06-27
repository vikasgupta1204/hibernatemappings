package com.sprng.manytomany.dtos;

import com.sprng.manytomany.models.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private List<Course> courses;
}
