package com.andreferreira.springbootmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreferreira.springbootmongo.domain.User;
import com.andreferreira.springbootmongo.dto.UserDTO;
import com.andreferreira.springbootmongo.repository.UserRepository;
import com.andreferreira.springbootmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findById(String id) {
		
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado!"));
		
		}
	
	public User insertUser(User user) {
		
		return repository.insert(user);
	}
	
	public User fromDTO (UserDTO userDTO) {
		
		return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
	}
}

