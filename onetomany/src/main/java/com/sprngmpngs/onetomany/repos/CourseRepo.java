package com.sprngmpngs.onetomany.repos;

import com.sprngmpngs.onetomany.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

    @Query(value = "select * from course where instructor_id =:id",nativeQuery = true)
    List<Course> findCourseByInstructorId(@Param("id") int id);
}
