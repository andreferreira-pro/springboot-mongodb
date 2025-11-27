package com.andreferreira.springbootmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andreferreira.springbootmongo.domain.Post;
import com.andreferreira.springbootmongo.domain.User;
import com.andreferreira.springbootmongo.dto.UserDTO;
import com.andreferreira.springbootmongo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> listUsers = userService.findAll();
		
		List<UserDTO> listDto = listUsers.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
											
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User userById = userService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(userById));
	}
	
	@PostMapping
	public ResponseEntity<Void> insertUser(@RequestBody UserDTO user){
		
		User insertUser = userService.fromDTO(user);
		
		insertUser = userService.insertUser(insertUser);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		
	userService.deleteById(id);
	
	return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody UserDTO userUpdate){
		
		User userRepo =  userService.fromDTO(userUpdate);
		
		userRepo.setId(id);
		
		userRepo = userService.updateUser(userRepo);
		
		return ResponseEntity.noContent().build();
		}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		
		User userById = userService.findById(id);
		
		return ResponseEntity.ok().body(userById.getPosts());
	}
	
	
	
	}
	
	
	
