package com.andreferreira.springbootmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andreferreira.springbootmongo.domain.Post;
import com.andreferreira.springbootmongo.domain.User;
import com.andreferreira.springbootmongo.dto.AuthorDTO;
import com.andreferreira.springbootmongo.dto.CommentDTO;
import com.andreferreira.springbootmongo.repository.PostRepository;
import com.andreferreira.springbootmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postResitory;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postResitory.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2025"), "Partiu viagem!!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(bob));
		Post post2 = new Post(null,sdf.parse("23/03/2025"), "Bom dia!!!", "Acordei Feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!!", sdf.parse("25/03/2025"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite bastante!!", sdf.parse("25/03/2025"), new AuthorDTO(maria));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!!", sdf.parse("26/03/2025"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(comment1,comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postResitory.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
