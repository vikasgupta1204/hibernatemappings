package com.sprngmpngs.onetomany.dtos;

import com.sprngmpngs.onetomany.models.Course;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class InstructorRequestDto {

    private int id;
    private String firstName;

    private String lastName;

    private String email;

    List<Course> courses;


}
