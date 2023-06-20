package com.sprngmpngs.onetomany.repos;

import com.sprngmpngs.onetomany.models.Instructor;
import org.antlr.v4.runtime.InterpreterRuleContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
}
