package com.sprng.manytomany.services;

import com.sprng.manytomany.dtos.CourseRequestDto;
import com.sprng.manytomany.dtos.CourseResponseDto;
import com.sprng.manytomany.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
public ResponseEntity<CourseResponseDto> addCourse(CourseRequestDto courseRequestDto);
ResponseEntity<List<CourseResponseDto>> getAllCourses();
ResponseEntity<CourseResponseDto> getCourseById(int id);
ResponseEntity<String> deleteCourseById(int id);
ResponseEntity<CourseResponseDto> editCourse(CourseRequestDto courseRequestDto);



}
