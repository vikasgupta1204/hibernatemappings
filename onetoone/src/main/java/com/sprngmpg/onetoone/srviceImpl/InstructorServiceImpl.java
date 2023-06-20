package com.sprngmpg.onetoone.srviceImpl;

import com.sprngmpg.onetoone.Repos.InstructorDetailRepo;
import com.sprngmpg.onetoone.Repos.InstructorRepo;
import com.sprngmpg.onetoone.dtos.InstructorRequest;
import com.sprngmpg.onetoone.dtos.InstructorResponse;
import com.sprngmpg.onetoone.exceptions.InstructorNotFoundException;
import com.sprngmpg.onetoone.models.Instructor;
import com.sprngmpg.onetoone.models.InstructorDetail;
import com.sprngmpg.onetoone.service.InstructorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Autowired
    private InstructorDetailRepo instructorDetailRepo;
    @Override
    public ResponseEntity<InstructorResponse> getInstructorById(int id) {
        Optional<Instructor> optionalInstructor=instructorRepo.findById(id);
        if(optionalInstructor.isEmpty()){
           throw new InstructorNotFoundException("instructor is not found");
        }
        Instructor instructor=optionalInstructor.get();
        InstructorResponse instructorResponse=new InstructorResponse();
        BeanUtils.copyProperties(instructor,instructorResponse);
        InstructorDetail instructorDetail=instructorDetailRepo.findById(Integer.parseInt
                (String.valueOf(instructor.getId()))).get();

        instructorResponse.setHobby(instructorDetail.getHobby());
        instructorResponse.setYoutubeChannel(instructorDetail.getYoutubeChannel());

        return new ResponseEntity<>(instructorResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<InstructorResponse>> getAllInstructors() {
        List<Instructor> instructors=instructorRepo.findAll();
        List<InstructorResponse> instructorResponses=new ArrayList<>();

        for(Instructor instructor:instructors){
            InstructorResponse instructorResponse=new InstructorResponse();
            instructorResponse.setId(Integer.parseInt(String.valueOf(instructor.getId())));
            instructorResponse.setFirstName(instructor.getFirstName());
            instructorResponse.setLastName(instructor.getLastName());
            instructorResponse.setEmail(instructor.getEmail());
            instructorResponse.setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());
            instructorResponse.setHobby(instructor.getInstructorDetail().getHobby());
            instructorResponses.add(instructorResponse);
        }

        return  new ResponseEntity<>(instructorResponses,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InstructorResponse> editInstructor(InstructorRequest instructorRequest) {

        Optional<Instructor> optionalInstructor=instructorRepo.findById(instructorRequest.getId());
        if(optionalInstructor.isEmpty()){
            throw  new InstructorNotFoundException("Instructor not found");
        }
        Instructor instructor=optionalInstructor.get();
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setFirstName(instructorRequest.getFirstName());
        int id=instructor.getInstructorDetail().getId();
        InstructorDetail instructorDetail=instructorDetailRepo.findById(id).get();
        instructorDetail.setYoutubeChannel(instructorRequest.getYoutubeChannel());
        instructorDetail.setHobby(instructorRequest.getHobby());
        instructor.setInstructorDetail(instructorDetail);
        instructorRepo.save(instructor);
        InstructorResponse instructorResponse=new InstructorResponse();
        BeanUtils.copyProperties(instructor,instructorResponse);
        instructorResponse.setHobby(instructor.getInstructorDetail().getHobby());
        instructorResponse.setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());
        return new ResponseEntity<>(instructorResponse,HttpStatus.OK);
    }

    @Override
    public void deleteInstructor(int id) {
        Optional<Instructor> optionalInstructor=instructorRepo.findById(id);
        if(optionalInstructor.isEmpty()){
            throw  new InstructorNotFoundException("Instructor not found");
        }

        Instructor instructor=optionalInstructor.get();
        instructorRepo.delete(instructor);
    }

    @Override
    public ResponseEntity<InstructorResponse> createInstructor(InstructorRequest instructorRequest) {
        Instructor instructor=new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());
        InstructorDetail instructorDetail=new InstructorDetail();
        instructorDetail.setHobby(instructorRequest.getHobby());
        instructorDetail.setYoutubeChannel(instructorRequest.getYoutubeChannel());
   //     InstructorDetail savedInstructorDetail= instructorDetailRepo.save(instructorDetail);
        instructor.setInstructorDetail(instructorDetail);
        Instructor savedInstructor=instructorRepo.save(instructor);
        InstructorResponse instructorResponse=new InstructorResponse();
        instructorResponse.setId(instructorResponse.getId());
        instructorResponse.setFirstName(savedInstructor.getFirstName());
        instructorResponse.setLastName(savedInstructor.getLastName());
        instructorResponse.setHobby(instructor.getInstructorDetail().getHobby());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());
        return new ResponseEntity<>(instructorResponse,HttpStatus.CREATED);
    }
}
