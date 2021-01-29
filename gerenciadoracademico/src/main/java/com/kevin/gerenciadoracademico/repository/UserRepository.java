package com.kevin.gerenciadoracademico.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kevin.gerenciadoracademico.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
