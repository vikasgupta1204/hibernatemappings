package com.sprngmpngs.onetomany.serviceimpl;

import com.sprngmpngs.onetomany.dtos.CourseRequestDto;
import com.sprngmpngs.onetomany.exceptions.CourseNotFoundWithGivenId;
import com.sprngmpngs.onetomany.models.Course;
import com.sprngmpngs.onetomany.models.Instructor;
import com.sprngmpngs.onetomany.repos.CourseRepo;
import com.sprngmpngs.onetomany.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;
    @Override
    public ResponseEntity<Course> addCourse(CourseRequestDto courseRequestDto) {
        Course course=new Course();
        course.setTitle(courseRequestDto.getTitle());
        course.setInstructor(courseRequestDto.getInstructor());
       Course course1= courseRepo.save(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseRepo.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCourse(int id) {
        Optional<Course> optionalCourse=courseRepo.findById(id);
        if(optionalCourse.isEmpty()){
            throw new CourseNotFoundWithGivenId("Course not found with "+id);
        }
        Course course=optionalCourse.get();
        courseRepo.delete(course);
        return new ResponseEntity<>("Deleted the course with "+id,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Course> editCourse(CourseRequestDto courseRequestDto) {
        Optional<Course> courseOptional=courseRepo.findById(courseRequestDto.getId());
        if(courseOptional.isEmpty()){
            throw new CourseNotFoundWithGivenId("Course not found with "+courseRequestDto.getId());
        }
        Course course=courseOptional.get();
        course.setTitle(courseRequestDto.getTitle());
        course.setInstructor(courseRequestDto.getInstructor());
        Course savedCourse= courseRepo.save(course);
        return new ResponseEntity<>(savedCourse,HttpStatus.OK);
    }
}
