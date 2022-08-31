package edu.unimagdalena.jpaexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.jpaexample.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
