package com.sprng.manytomany.controllers;

import com.sprng.manytomany.dtos.CourseResponseProjection;
import com.sprng.manytomany.dtos.StudentRequestDto;
import com.sprng.manytomany.dtos.StudentResponseDto;
import com.sprng.manytomany.services.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/createStudent")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/get/student/{id}")
    public  ResponseEntity<StudentResponseDto> findStudentById(@PathVariable("id") int id){
       return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
       return studentService.deleteStudentById(id);
    }
    @GetMapping("/get/all/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return studentService.getAllStudents();
    }
    @PutMapping("/update/student")
    public ResponseEntity<StudentResponseDto> updateStudent(@RequestBody StudentRequestDto studentRequestDto){
        return  studentService.editStudent(studentRequestDto);
    }

    @GetMapping("/get/courses/by/student/{id}")
    public ResponseEntity<List<CourseResponseProjection>> getCoursesWithStudentId(@PathVariable("id") int id){
        return studentService.getCoursesForStudent(id);
    }
}
