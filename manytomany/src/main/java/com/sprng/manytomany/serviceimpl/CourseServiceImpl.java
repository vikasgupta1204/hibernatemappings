package com.sprng.manytomany.serviceimpl;

import com.sprng.manytomany.dtos.CourseRequestDto;
import com.sprng.manytomany.dtos.CourseResponseDto;
import com.sprng.manytomany.exceptions.CourseNotFoundException;
import com.sprng.manytomany.exceptions.NoDataFoundException;
import com.sprng.manytomany.models.Course;
import com.sprng.manytomany.repos.CourseRepo;
import com.sprng.manytomany.repos.StudentRepo;
import com.sprng.manytomany.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;
    @Autowired
    StudentRepo studentRepo;
    @Override
    public ResponseEntity<CourseResponseDto> addCourse(CourseRequestDto courseRequestDto) {
        Course course=new Course();
        BeanUtils.copyProperties(courseRequestDto,course);
        Course savedCourse=courseRepo.save(course);
        CourseResponseDto courseResponseDto=new CourseResponseDto();
        BeanUtils.copyProperties(savedCourse,courseResponseDto);
        return new ResponseEntity<>(courseResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<Course> courses=courseRepo.findAll();
        if(courses.isEmpty()){
            throw new NoDataFoundException("No course found in database");
        }
        List<CourseResponseDto> courseResponseDtos=new ArrayList<>();
        for(Course c:courses){
            CourseResponseDto courseResponseDto=new CourseResponseDto();
            BeanUtils.copyProperties(c,courseResponseDto);
            courseResponseDtos.add(courseResponseDto);
        }
        return new ResponseEntity<>(courseResponseDtos,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseResponseDto> getCourseById(int id) {
        Optional<Course> courseOptional=courseRepo.findById(id);
        if(courseOptional.isEmpty()){
            throw new CourseNotFoundException("course is not found with id "+id);
        }
        Course course=courseOptional.get();
        CourseResponseDto courseResponseDto=new CourseResponseDto();
        BeanUtils.copyProperties(course,courseResponseDto);
        return new ResponseEntity<>(courseResponseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCourseById(int id) {
        Optional<Course> courseOptional=courseRepo.findById(id);
        if(courseOptional.isEmpty()){
            throw new CourseNotFoundException("course is not found with id "+id);
        }
        Course course=courseOptional.get();
        courseRepo.delete(course);

        return new ResponseEntity<>("Course deleted with id "+id,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CourseResponseDto> editCourse(CourseRequestDto courseRequestDto) {
        Optional<Course> courseOptional=courseRepo.findById(courseRequestDto.getId());
        if(courseOptional.isEmpty()){
            throw new CourseNotFoundException("course is not found with id "+courseRequestDto.getId());
        }
        Course course=courseOptional.get();
        BeanUtils.copyProperties(courseRequestDto,course);
        Course updateCourse=courseRepo.save(course);
        CourseResponseDto courseResponseDto=new CourseResponseDto();
        BeanUtils.copyProperties(updateCourse,courseResponseDto);
        return new ResponseEntity<>(courseResponseDto,HttpStatus.OK);
    }
}
