package edu.unimagdalena.jpaexample.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.unimagdalena.jpaexample.model.CourseMaterial;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long>{
    
}
