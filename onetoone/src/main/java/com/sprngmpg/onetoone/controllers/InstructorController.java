package com.sprngmpg.onetoone.controllers;

import com.sprngmpg.onetoone.dtos.InstructorRequest;
import com.sprngmpg.onetoone.dtos.InstructorResponse;
import com.sprngmpg.onetoone.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @GetMapping("/get/{id}")
    public ResponseEntity<InstructorResponse> getInstructorDetails(@PathVariable("id") int id){
        return  instructorService.getInstructorById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<InstructorResponse> createInstructor(@RequestBody InstructorRequest instructorRequest){
        return instructorService.createInstructor(instructorRequest);
    }

    @PutMapping("/edit")
    public ResponseEntity<InstructorResponse> editInstructor(@RequestBody InstructorRequest instructorRequest){
        return instructorService.editInstructor(instructorRequest);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<InstructorResponse>> getAllInstructors(){
        return  instructorService.getAllInstructors();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInstructor(@PathVariable("id") int id){
        instructorService.deleteInstructor(id);
    }
}
