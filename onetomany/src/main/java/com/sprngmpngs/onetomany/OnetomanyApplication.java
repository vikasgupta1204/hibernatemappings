package com.sprngmpngs.onetomany;

import com.sprngmpngs.onetomany.models.Course;
import com.sprngmpngs.onetomany.models.Instructor;
import com.sprngmpngs.onetomany.repos.CourseRepo;
import com.sprngmpngs.onetomany.repos.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OnetomanyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OnetomanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        findInstructorWithCourses();
    }

    @Autowired
    private InstructorRepo instructorRepo;
    @Autowired
    private CourseRepo courseRepo;
    private void findInstructorWithCourses(){
        int theId=1;
        System.out.println("Finding instructor id:"+theId);
        Instructor tempInstructor=instructorRepo.findById(theId).get();
        System.out.println(tempInstructor.getFirstName()+"::"+tempInstructor.getLastName()
        +"::"+tempInstructor.getEmail()+"::"+tempInstructor.getId());
//        for (Course course:tempInstructor.getCourses()) {
//            System.out.println("The associated courses:" + course.getTitle()+"::"+course.getId()+"::"+course.getInstructor());
//        }
        List<Course> courses=courseRepo.findCourseByInstructorId(theId);

        for (Course course:courses) {
          System.out.println("The associated courses:" + course.getTitle()+"::"+course.getId()+"::"+course.getInstructor());
        }
        tempInstructor.setCourses(courses);
        System.out.println(tempInstructor.getCourses());
        System.out.println("Done!");
    }
}
