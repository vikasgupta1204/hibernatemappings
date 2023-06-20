package com.sprngmpngs.onetomany.controllers;

import com.sprngmpngs.onetomany.dtos.InstructorRequestDto;
import com.sprngmpngs.onetomany.models.Instructor;
import com.sprngmpngs.onetomany.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class InstructorController {

    @Autowired
    InstructorService instructorService;



    @PostMapping("/create")
    public ResponseEntity<Instructor> createInstructor(@RequestBody InstructorRequestDto instructorRequestDto){
        return instructorService.createInstrutor(instructorRequestDto);
    }

    @PutMapping("/edit")
    public ResponseEntity<Instructor> editInstructor( @RequestBody InstructorRequestDto instructorRequestDto){
        return instructorService.updateInstructor(instructorRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable("id") int id){
       return instructorService.deleteInstructor(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Instructor>> findAllInstructor(){
        return instructorService.getAllInstructors();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable("id") int id){
        return instructorService.findInstructorById(id);
    }


}
