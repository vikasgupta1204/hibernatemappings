package com.sprngmpg.onetoone.service;

import com.sprngmpg.onetoone.dtos.InstructorRequest;
import com.sprngmpg.onetoone.dtos.InstructorResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface InstructorService {
    public ResponseEntity<InstructorResponse> getInstructorById(int id);
    public ResponseEntity<List<InstructorResponse>> getAllInstructors();
    public ResponseEntity<InstructorResponse> editInstructor(InstructorRequest instructorRequest
    );
    public void deleteInstructor(int id);

    public ResponseEntity<InstructorResponse> createInstructor(InstructorRequest instructorRequest);
}
