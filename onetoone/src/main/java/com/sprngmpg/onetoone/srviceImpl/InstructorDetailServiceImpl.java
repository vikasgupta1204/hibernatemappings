package com.sprngmpg.onetoone.srviceImpl;

import com.sprngmpg.onetoone.Repos.InstructorDetailRepo;
import com.sprngmpg.onetoone.Repos.InstructorRepo;
import com.sprngmpg.onetoone.exceptions.InstructorDetailNotFoundWithGivenIdException;
import com.sprngmpg.onetoone.exceptions.InstructorNotFoundException;
import com.sprngmpg.onetoone.models.Instructor;
import com.sprngmpg.onetoone.models.InstructorDetail;
import com.sprngmpg.onetoone.service.InstructorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
    @Autowired
    private InstructorDetailRepo instructorDetailRepo;
    @Autowired
    private InstructorRepo instructorRepo;
    @Override
    public ResponseEntity<String> deleteInstructorDetail(int id) {
        Optional<InstructorDetail> optionalInstructorDetail=null;

            optionalInstructorDetail = instructorDetailRepo.findById(id);

            if(optionalInstructorDetail.isEmpty()) {
                throw new InstructorDetailNotFoundWithGivenIdException("Instructor detail is not found with id " + id);
            }
            InstructorDetail instructorDetail=optionalInstructorDetail.get();


        Instructor instructor=instructorRepo.findById(Integer.parseInt(String
                .valueOf(instructorDetail.getInstructor().getId()))).get();

        instructor.setInstructorDetail(null);
        instructorRepo.save(instructor);;
        instructorDetailRepo.delete(instructorDetail);
        return new ResponseEntity<>("Instructor detail is successfully deleted with id "+id, HttpStatus.OK);
    }
}
