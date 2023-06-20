package com.sprngmpg.onetoone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface InstructorDetailService {
public ResponseEntity<String> deleteInstructorDetail(int id);
}
