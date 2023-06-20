package com.sprngmpngs.onetomany.services;

import com.sprngmpngs.onetomany.dtos.InstructorRequestDto;
import com.sprngmpngs.onetomany.models.Instructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
public ResponseEntity<Instructor> createInstrutor(InstructorRequestDto instructorRequestDto);
public ResponseEntity<Instructor> findInstructorById(int id);
public ResponseEntity<List<Instructor>> getAllInstructors();

ResponseEntity<String> deleteInstructor(int id);

ResponseEntity<Instructor> updateInstructor(InstructorRequestDto instructorRequestDto);
}
