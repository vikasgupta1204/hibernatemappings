package com.sprngmpg.onetoone.controllers;

import com.sprngmpg.onetoone.service.InstructorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detail")
public class InstructorDetailController {

    @Autowired
    private InstructorDetailService instructorDetailService;

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable("id") int id){
        return instructorDetailService.deleteInstructorDetail(id);
    }
}
