package edu.unimagdalena.jpaexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.jpaexample.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
