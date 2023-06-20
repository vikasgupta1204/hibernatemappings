package com.sprngmpg.onetoone.dtos;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class InstructorRequest {
    private  int id;
private String firstName;
private  String lastName;
private String email;
private  String hobby;
private String youtubeChannel;
}
