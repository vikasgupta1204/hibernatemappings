package com.sprng.manytomany.repos;

import com.sprng.manytomany.dtos.CourseResponseProjection;
import com.sprng.manytomany.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    @Query(value = "select c.id as courseId ," +
            " c.title as courseTitle " +
            " from course_student cs left outer join student s on cs.student_id=s.id left outer join course c on " +
            "c.id=cs.course_id where s.id = :id  ",nativeQuery = true)
     List<CourseResponseProjection> getCoursesByStudentId(@Param("id") int id);
}
