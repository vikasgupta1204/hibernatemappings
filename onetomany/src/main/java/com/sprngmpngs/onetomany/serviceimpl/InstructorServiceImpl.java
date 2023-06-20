package com.sprngmpngs.onetomany.serviceimpl;

import com.sprngmpngs.onetomany.dtos.InstructorRequestDto;
import com.sprngmpngs.onetomany.exceptions.InstructorNotFoundWithGivenId;
import com.sprngmpngs.onetomany.models.Course;
import com.sprngmpngs.onetomany.models.Instructor;
import com.sprngmpngs.onetomany.repos.CourseRepo;
import com.sprngmpngs.onetomany.repos.InstructorRepo;
import com.sprngmpngs.onetomany.services.InstructorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    CourseRepo courseRepo;
    @Override
    public ResponseEntity<Instructor> createInstrutor(InstructorRequestDto instructorRequestDto) {
        Instructor instructor=new Instructor();
        BeanUtils.copyProperties(instructorRequestDto,instructor);
        List<Course> courses=instructorRequestDto.getCourses();
        if(courses!=null&&!courses.isEmpty()){
            for(Course course:courses){
                course.setInstructor(instructor);
            }
        }
        Instructor savedInstructor=instructorRepo.save(instructor);

        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Instructor> findInstructorById(int id) {
        Optional<Instructor> instructorOptional=instructorRepo.findById(id);
        if(instructorOptional.isEmpty()){
            throw new InstructorNotFoundWithGivenId("Instructor not found with id "+id);
        }
        Instructor instructor=instructorOptional.get();
        return new ResponseEntity<>(instructor,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors=instructorRepo.findAll();
        return new ResponseEntity<>(instructors,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteInstructor(int id) {
        Optional<Instructor> instructorOptional=instructorRepo.findById(id);
        if(instructorOptional.isEmpty()){
            throw new InstructorNotFoundWithGivenId("Instructor not found with id "+id);
        }
        List<Course> courses=instructorOptional.get().getCourses();
        for(Course course:courses){
            course.setInstructor(null);
            courseRepo.save(course);
        }
        instructorRepo.delete(instructorOptional.get());
        return new ResponseEntity<>("Deleted:"+instructorOptional.get().getId()+":"+
                instructorOptional.get().getFirstName(),HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Instructor> updateInstructor(InstructorRequestDto instructorRequestDto) {
        Optional<Instructor> instructorOptional=instructorRepo.findById(instructorRequestDto.getId());
        if(instructorOptional.isEmpty()){
            throw new InstructorNotFoundWithGivenId("Instructor not found with id "+instructorRequestDto.getId());
        }
        Instructor instructor=instructorOptional.get();
        instructor.setFirstName(instructorRequestDto.getFirstName());
        instructor.setLastName(instructorRequestDto.getLastName());
        instructor.setEmail(instructorRequestDto.getEmail());
        instructor.setCourses(instructorRequestDto.getCourses());
      Instructor updInstructor1=  instructorRepo.save(instructor);
        return new ResponseEntity<>(updInstructor1,HttpStatus.OK);
    }
}
