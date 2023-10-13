package com.labs.managerstore.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.managerstore.models.User;

@RestController
@RequestMapping(value = "/users")
public class UserRessources {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User("Jonh Doe","jonhdoe@gmail.com","logradouro","password");
		return ResponseEntity.ok().body(user);			
	}
	

}
