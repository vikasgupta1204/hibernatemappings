package com.sprng.manytomany.dtos;

import com.sprng.manytomany.models.Student;
import lombok.Data;

import java.util.List;

@Data
public class CourseResponseDto {
    int id;
    String title;
    List<Student> students;
}
