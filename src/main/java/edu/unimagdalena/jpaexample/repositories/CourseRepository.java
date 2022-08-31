package edu.unimagdalena.jpaexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.unimagdalena.jpaexample.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
