package com.kevin.grademanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kevin.grademanager.domain.Grade;

@Repository
public interface GradeRepository extends MongoRepository<Grade, String> {

}
