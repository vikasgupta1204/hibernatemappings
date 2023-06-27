package com.sprng.manytomany.controllers;

import com.sprng.manytomany.dtos.CourseRequestDto;
import com.sprng.manytomany.dtos.CourseResponseDto;
import com.sprng.manytomany.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDto> saveCourse(@RequestBody CourseRequestDto courseRequestDto){
        return courseService.addCourse(courseRequestDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CourseResponseDto> findCourseById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CourseResponseDto>> getAllCourses(){
        return courseService.getAllCourses();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") int id){
        return courseService.deleteCourseById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<CourseResponseDto> editCourse(@RequestBody CourseRequestDto courseRequestDto){
        return courseService.editCourse(courseRequestDto);
    }

}
