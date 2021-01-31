package com.kevin.gerenciadoracademico.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kevin.gerenciadoracademico.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
