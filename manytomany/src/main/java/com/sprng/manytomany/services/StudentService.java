package com.sprng.manytomany.services;


import com.sprng.manytomany.dtos.CourseResponseProjection;
import com.sprng.manytomany.dtos.StudentRequestDto;
import com.sprng.manytomany.dtos.StudentResponseDto;
import com.sprng.manytomany.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    ResponseEntity<StudentResponseDto> addStudent(StudentRequestDto studentRequestDto);
    ResponseEntity<List<StudentResponseDto>> getAllStudents();
    ResponseEntity<StudentResponseDto> getStudentById(int id);
    ResponseEntity<String> deleteStudentById(int id);
    ResponseEntity<StudentResponseDto> editStudent(StudentRequestDto studentRequestDto);
    ResponseEntity<List<CourseResponseProjection>> getCoursesForStudent(int id);
}
