package com.andreferreira.springbootmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreferreira.springbootmongo.domain.Post;
import com.andreferreira.springbootmongo.repository.PostRepository;
import com.andreferreira.springbootmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	/*
	 * public List<Post> findAll(){
	 * 
	 * return postRepository.findAll(); }
	 */
	
	public Post findById(String id) {
		
		Optional<Post> post = postRepository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado!"));
		
		}
	
}

