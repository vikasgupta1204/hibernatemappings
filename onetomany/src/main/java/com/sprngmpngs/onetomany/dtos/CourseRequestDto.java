package com.sprngmpngs.onetomany.dtos;

import com.sprngmpngs.onetomany.models.Instructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CourseRequestDto {
    int id;
    private String title;
    private Instructor instructor;
}
