package com.andreferreira.springbootmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreferreira.springbootmongo.domain.Post;
import com.andreferreira.springbootmongo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	/*
	 * @GetMapping public ResponseEntity<List<PostDTO>> findAll(){
	 * 
	 * List<Post> lisPosts = postService.findAll();
	 * 
	 * List<PostDTO> listPostsDto = listPosts.stream().map(user -> new
	 * PostDTO(Post)).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(listPostsDtos); }
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post postById = postService.findById(id);
		
		return ResponseEntity.ok().body(postById);
	}
	
	/*
	 * @PostMapping public ResponseEntity<Void> insertUser(@RequestBody UserDTO
	 * user){
	 * 
	 * User insertUser = userService.fromDTO(user);
	 * 
	 * insertUser = userService.insertUser(insertUser);
	 * 
	 * URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (insertUser.getId()).toUri();
	 * 
	 * return ResponseEntity.created(uri).build(); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void> deleteUser(@PathVariable
	 * String id){
	 * 
	 * userService.deleteById(id);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<Void> updateUser(@PathVariable
	 * String id, @RequestBody UserDTO userUpdate){
	 * 
	 * User userRepo = userService.fromDTO(userUpdate);
	 * 
	 * userRepo.setId(id);
	 * 
	 * userRepo = userService.updateUser(userRepo);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 */
	
	
	
	
	}
	
	
	
