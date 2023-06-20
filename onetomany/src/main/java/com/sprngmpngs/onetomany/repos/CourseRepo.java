package com.sprngmpngs.onetomany.repos;

import com.sprngmpngs.onetomany.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {
}
