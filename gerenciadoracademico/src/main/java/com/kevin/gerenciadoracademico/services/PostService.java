package com.kevin.gerenciadoracademico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.gerenciadoracademico.domain.Post;
import com.kevin.gerenciadoracademico.domain.User;
import com.kevin.gerenciadoracademico.repository.PostRepository;
import com.kevin.gerenciadoracademico.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo; 
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
