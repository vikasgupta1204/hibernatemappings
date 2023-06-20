package com.sprngmpg.onetoone.Repos;

import com.sprngmpg.onetoone.models.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepo extends JpaRepository<InstructorDetail,Integer> {
}
