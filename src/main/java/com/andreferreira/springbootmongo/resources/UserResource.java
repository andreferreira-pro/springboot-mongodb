package com.andreferreira.springbootmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreferreira.springbootmongo.domain.User;
import com.andreferreira.springbootmongo.dto.UserDTO;
import com.andreferreira.springbootmongo.service.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> listUsers = userService.findAll();
		
		List<UserDTO> listDto = listUsers.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
											
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User userById = userService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(userById));
	}
	
	
	
	
	
}
