package com.sprngmpngs.onetomany.services;

import com.sprngmpngs.onetomany.dtos.CourseRequestDto;
import com.sprngmpngs.onetomany.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    ResponseEntity<Course>  addCourse(CourseRequestDto courseRequestDto);
    ResponseEntity<List<Course>> getAllCourses();
    ResponseEntity<String> deleteCourse(int id);
    ResponseEntity<Course> editCourse(CourseRequestDto courseRequestDto);
}
