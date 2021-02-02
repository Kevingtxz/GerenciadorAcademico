package com.kevin.grademanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kevin.grademanager.dto.StudentDTO;

@Repository
public interface StudentRepository extends MongoRepository<StudentDTO, String> {

}
