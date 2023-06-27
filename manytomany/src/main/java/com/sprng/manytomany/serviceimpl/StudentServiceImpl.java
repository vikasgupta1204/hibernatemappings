package com.sprng.manytomany.serviceimpl;

import com.sprng.manytomany.dtos.CourseResponseProjection;
import com.sprng.manytomany.dtos.StudentRequestDto;
import com.sprng.manytomany.dtos.StudentResponseDto;
import com.sprng.manytomany.exceptions.NoDataFoundException;
import com.sprng.manytomany.exceptions.StudentNotFoundException;
import com.sprng.manytomany.models.Course;
import com.sprng.manytomany.models.Student;
import com.sprng.manytomany.repos.CourseRepo;
import com.sprng.manytomany.repos.StudentRepo;
import com.sprng.manytomany.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Override
    public ResponseEntity<StudentResponseDto> addStudent(StudentRequestDto studentRequestDto) {
        Student student=new Student();
        BeanUtils.copyProperties(studentRequestDto,student);
        List<Course> allCourses=courseRepo.findAll();
        HashSet<String> courseHashSet=new HashSet<>();
        allCourses.stream().forEach(a->courseHashSet.add(a.getTitle().toLowerCase()));
        for(Course course:studentRequestDto.getCourses()){
            List<Student> students=course.getStudents();
            if(courseHashSet.contains(course.getTitle().toLowerCase())){
                if(students==null){
                    students=new ArrayList<>();
                }
                students.add(student);
                student.getCourses().remove(course);
            }
            else{
                if(students==null){
                    students=new ArrayList<>();
                }
                students.add(student);
            }

       }
        Student savedSudent=studentRepo.save(student);
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        BeanUtils.copyProperties(savedSudent,studentResponseDto);
        return new ResponseEntity<>(studentResponseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        List<Student> studentList=studentRepo.findAll();
        if(studentList.isEmpty()){
            throw new NoDataFoundException("Not student found in the database");
        }
        List<StudentResponseDto> studentResponseDtos=new ArrayList<>();
        for(Student s:studentList){
            StudentResponseDto studentResponseDto=new StudentResponseDto();
            BeanUtils.copyProperties(s,studentResponseDto);
            studentResponseDtos.add(studentResponseDto);
        }

        return new ResponseEntity<>(studentResponseDtos,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StudentResponseDto> getStudentById(int id) {
        Optional<Student> optionalStudent=studentRepo.findById(id);
        if(!optionalStudent.isPresent()){
            throw new StudentNotFoundException("Student not found with id "+id);
        }

        Student s=optionalStudent.get();
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        BeanUtils.copyProperties(s,studentResponseDto);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteStudentById(int id) {
        Optional<Student> optionalStudent=studentRepo.findById(id);
        if(!optionalStudent.isPresent()){
            throw new StudentNotFoundException("Student not found with id "+id);
        }

        Student s=optionalStudent.get();
        studentRepo.delete(s);
        return new ResponseEntity<>("Student deleted with id "+id,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<StudentResponseDto> editStudent( StudentRequestDto studentRequestDto) {
        Optional<Student> optionalStudent=studentRepo.findById(studentRequestDto.getId());
        if(!optionalStudent.isPresent()){
            throw new StudentNotFoundException("Student not found with id "+studentRequestDto.getId());
        }

        Student s=optionalStudent.get();
        BeanUtils.copyProperties(s,studentRequestDto);
        Student updateStudent=studentRepo.save(s);
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        BeanUtils.copyProperties(updateStudent,studentResponseDto);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseResponseProjection>> getCoursesForStudent(int id) {
        List<CourseResponseProjection> courseResponseProjections=studentRepo.getCoursesByStudentId(id);
        return new ResponseEntity<>(courseResponseProjections,HttpStatus.OK);
    }
}
